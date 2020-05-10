package com.lending.application.repositories

import com.lending.application.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findAllByOrderByFirstname(): List<User>
}
