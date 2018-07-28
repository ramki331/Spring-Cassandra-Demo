package com.kroger.dcp.fraud.poc.converter

import com.fasterxml.jackson.databind.ObjectMapper
import com.kroger.dcp.fraud.poc.model.Order
import org.springframework.core.convert.converter.Converter

class OrderConverter : Converter<Order, String> {
    override fun convert(source: Order?): String {
        return when {
            source != null -> ObjectMapper().writeValueAsString(source)
            else -> "{NO DATA}"
        }
    }
}