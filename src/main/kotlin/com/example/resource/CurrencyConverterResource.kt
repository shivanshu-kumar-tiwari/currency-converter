package com.example.resource

import com.example.dto.CurrencyConverterDTO
import com.example.service.CurrencyConverterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/currency")
class CurrencyConverterResource {

    @Autowired
    private lateinit var currencyConverterService: CurrencyConverterService

    @GetMapping("/converter")
    fun currencyConverter(
        @RequestParam("to") to: String,
        @RequestParam("from") from: String,
        @RequestParam("amount") amount: Int
    ): CurrencyConverterDTO {

        return currencyConverterService.currencyConverter(to, from, amount)
    }

}
