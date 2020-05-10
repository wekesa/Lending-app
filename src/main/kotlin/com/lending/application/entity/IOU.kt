package com.lending.application.entity

//import org.springframework.data.rest.core.annotation.RestResource
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class IOU(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @ManyToOne
    @JoinColumn(name = "user_lender_id")
    val lender: User,

    @ManyToOne
    @JoinColumn(name = "user_borrower_id")
    val borrower: User,

    val amount: BigDecimal,

    val addedAt: LocalDateTime = LocalDateTime.now()
)
