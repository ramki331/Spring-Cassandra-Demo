package com.kroger.dcp.fraud.poc.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Order(
//    val createdDate: Instant,
    val etag: String,
//    val loyaltyCardNumber: String,
    val masterOrderId: String,
    val masterOrderUuid: String,
//    val profileId: String,
    val status: OrderStatus,
    val subOrders: List<SubOrder>,
//    val uuidVersion: String,
    val validDraft: Boolean
//    val version: Int
)

enum class OrderStatus {
    Pending,
    Complete
}

