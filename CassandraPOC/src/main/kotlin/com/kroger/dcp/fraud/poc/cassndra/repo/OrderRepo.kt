package com.kroger.dcp.fraud.poc.cassndra.repo

import com.kroger.dcp.fraud.poc.model.FraudVerificationData
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface OrderRepo : CassandraRepository<FraudVerificationData> {
    fun findByOrderId(@Param("order_id") orderId: String): FraudVerificationData
}