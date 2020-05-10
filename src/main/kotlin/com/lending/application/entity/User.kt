package com.lending.application.entity

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,
    @get: NotBlank
    val firstname: String,

    val lastname: String? = null,

    val description: String? = null,

    val addedAt: LocalDateTime = LocalDateTime.now()
)
