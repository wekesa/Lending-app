package com.lending.application.controllers

import com.lending.application.entity.User
import com.lending.application.repositories.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(private val userRepository: UserRepository) {

    @GetMapping
    fun getUsers(): List<User> = userRepository.findAll()
}
