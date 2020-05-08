package com.lending.application.entity

import jdk.internal.jline.internal.Nullable
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,
    @get: NotBlank
    val firstname: String,
    val lastname: String,
    var description: String? = null,
    var addedAt: LocalDateTime = LocalDateTime.now()
)
