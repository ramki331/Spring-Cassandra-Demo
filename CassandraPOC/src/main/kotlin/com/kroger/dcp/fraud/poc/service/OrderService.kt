package com.kroger.dcp.fraud.poc.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.common.io.Resources
import com.kroger.dcp.fraud.poc.model.FraudVerificationData
import com.kroger.dcp.fraud.poc.model.Order
import com.kroger.dcp.fraud.poc.repo.IOrderRepo
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.nio.charset.Charset

@Component
class OrderService(
    val orderRepo: IOrderRepo
) {

    fun readOrderFromJson(): Order {
        var mapper: ObjectMapper = jacksonObjectMapper()
        val order: Order = mapper.readValue(
            Resources.toString(ClassPathResource("/order.json").url, Charset.defaultCharset()),
            Order::class.java)
        System.out.println(order)
        return order
    }

    fun createFraudVerificationRequest(): FraudVerificationData {

        val order = readOrderFromJson()

        return FraudVerificationData(order.masterOrderId, order)
    }

    fun insertFraudData() {
        System.out.println("inserting the data...")
        orderRepo.save(createFraudVerificationRequest())
    }

    fun readFraudDataFromRepo(orderId: String): FraudVerificationData {
        val dataFromDB = orderRepo.findByOrderId(orderId)
        System.out.println(dataFromDB)
        return dataFromDB
    }

}