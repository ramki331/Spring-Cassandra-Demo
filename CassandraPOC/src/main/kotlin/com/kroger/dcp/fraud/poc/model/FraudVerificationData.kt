package com.kroger.dcp.fraud.poc.model

import org.springframework.data.cassandra.mapping.Column
import org.springframework.data.cassandra.mapping.PrimaryKey
import org.springframework.data.cassandra.mapping.Table


@Table("fraud_data_by_order_id")

data class FraudVerificationData(
    @PrimaryKey("order_id")
    val orderId: String,
    @Column("customer_data")
    val order: Order?
)
