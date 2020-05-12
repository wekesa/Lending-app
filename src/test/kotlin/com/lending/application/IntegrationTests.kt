package com.lending.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

    @BeforeAll
    fun setup() {
        println(">> Setup")
    }
    @Test
    fun `Assert Users are fetched `() {
        val entity = restTemplate.getForEntity("/api/users", String::class.java)
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    }
    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }
}
