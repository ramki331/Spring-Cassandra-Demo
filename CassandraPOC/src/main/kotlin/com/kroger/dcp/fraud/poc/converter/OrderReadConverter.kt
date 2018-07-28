package com.kroger.dcp.fraud.poc.converter

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.kroger.dcp.fraud.poc.model.Order
import org.springframework.core.convert.converter.Converter

class OrderReadConverter : Converter<String, Order> {
    override fun convert(source: String?): Order {

        return when {
            source != null -> jacksonObjectMapper().readValue(source, Order::class.java)
            else -> jacksonObjectMapper().readValue("{NO CONTENT}", Order::class.java)
        }

    }


}