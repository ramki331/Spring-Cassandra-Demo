package com.kroger.dcp.fraud.poc.controller

import com.kroger.dcp.fraud.poc.model.FraudVerificationData
import com.kroger.dcp.fraud.poc.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cassandra")
class TestController @Autowired constructor(

    private val service: OrderService

) {

    @GetMapping("/read")
    fun readOrderData(): ResponseEntity<FraudVerificationData> {
        System.out.println("In read")
        val response = service.readFraudDataFromRepo("ramakrishna")
        return ResponseEntity.ok(response)
    }


    @PostMapping("/insert")
    fun createOrder(): ResponseEntity<Void> {
        System.out.println("In read")
        service.insertFraudData();
        return ResponseEntity(HttpStatus.OK)
    }


}