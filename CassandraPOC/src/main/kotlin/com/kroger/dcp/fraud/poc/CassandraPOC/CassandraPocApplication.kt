package com.kroger.dcp.fraud.poc.CassandraPOC

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.kroger.dcp.fraud.poc")
class CassandraPocApplication

fun main(args: Array<String>) {
    SpringApplication.run(CassandraPocApplication::class.java, *args)
}
