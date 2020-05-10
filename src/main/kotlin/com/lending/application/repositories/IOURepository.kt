package com.lending.application.repositories

import com.lending.application.entity.IOU
import com.lending.application.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IOURepository : JpaRepository<IOU, Long> {

    fun findByLender(lender: User): IOU?

    fun deleteByLender(lender: User)

    fun deleteAllByLender(lender: User)

    fun deleteAllByBorrower(borrower: User)
}
