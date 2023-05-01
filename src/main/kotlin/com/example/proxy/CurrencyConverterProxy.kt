package com.example.proxy

import com.example.dto.CurrencyConverterDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "currency-converter-proxy", url = "\${app.currency.converter.convert}")
interface CurrencyConverterProxy {

    @RequestMapping("", method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun currencyConverter(
        @RequestParam("to") to: String,
        @RequestParam("from") from: String,
        @RequestParam("amount") amount: Int,
        @RequestHeader("apikey") apikey: String
    ): CurrencyConverterDTO
}
