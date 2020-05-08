package com.lending.application.repositories

import com.lending.application.entity.Transaction
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface TransactionRepository : CrudRepository<Transaction, Long>  {
}
