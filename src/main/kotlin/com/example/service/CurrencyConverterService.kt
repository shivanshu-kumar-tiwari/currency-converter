package com.example.service

import com.example.dto.CurrencyConverterDTO
import com.example.proxy.CurrencyConverterProxy
import com.univocity.parsers.common.DataProcessingException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class CurrencyConverterService(
    @Value("\${app.currency.apiKey}") val apiKey: String
) {

    @Autowired
    private lateinit var currencyConverterProxy: CurrencyConverterProxy

    fun currencyConverter(to: String, from: String, amount: Int): CurrencyConverterDTO {
        try{
            return currencyConverterProxy.currencyConverter(to, from, amount, apiKey)
        }catch (e: Exception){
            throw DataProcessingException("Converter API Failed with message: ${e.message}")
        }
    }

}