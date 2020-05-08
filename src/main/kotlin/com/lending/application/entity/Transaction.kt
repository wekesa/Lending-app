package com.lending.application.entity

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,
    @ManyToOne val lender: User,
    @ManyToOne val borrower: User,
    val amount: BigDecimal,
    val addedAt: LocalDateTime = LocalDateTime.now()
)
