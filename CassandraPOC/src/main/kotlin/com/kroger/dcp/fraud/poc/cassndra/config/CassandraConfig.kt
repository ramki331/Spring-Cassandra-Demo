package com.kroger.dcp.fraud.poc.cassndra.config

import com.datastax.driver.core.PoolingOptions
import com.datastax.driver.core.policies.LoadBalancingPolicy
import com.kroger.dcp.fraud.poc.converter.OrderConverter
import com.kroger.dcp.fraud.poc.converter.OrderReadConverter
import org.springframework.cassandra.config.CassandraCqlClusterFactoryBean
import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.SchemaAction
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration
import org.springframework.data.cassandra.convert.CustomConversions
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories


@Configuration
@EnableCassandraRepositories(basePackages = ["com.kroger.dcp.fraud.poc"])
class CassandraConfig : AbstractCassandraConfiguration(

) {

    override fun getKeyspaceName(): String {
        return "fraud_api"
    }

    override fun getContactPoints(): String {
        return "127.0.0.1"
    }

    override fun getPort(): Int {
        return 9042
    }

    override fun getSchemaAction(): SchemaAction {
        return SchemaAction.CREATE_IF_NOT_EXISTS
    }

    override fun customConversions(): CustomConversions {
        return CustomConversions(
            listOf(
                OrderConverter(),
                OrderReadConverter()
            )
        )
    }


    override fun cluster(): CassandraCqlClusterFactoryBean {
        var cluster = super.cluster()
//    cluster.setUsername(username)
//    cluster.setPassword(password)
        System.out.print("in cluster")
        return cluster;
    }

    override fun getPoolingOptions(): PoolingOptions {
        var poolingOptions = PoolingOptions()
        poolingOptions.poolTimeoutMillis = 5000
        return poolingOptions
    }

    override fun getLoadBalancingPolicy(): LoadBalancingPolicy {

    }

}