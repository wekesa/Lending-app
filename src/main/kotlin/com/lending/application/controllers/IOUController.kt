package com.lending.application.controllers

import com.lending.application.entity.IOU
import com.lending.application.repositories.IOURepository
import com.lending.application.repositories.UserRepository
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/iou")
class IOUController(
    private val IOURepository: IOURepository,
    private val userRepository: UserRepository
) {
    @GetMapping
    fun getTransactions(): List<IOU> = IOURepository.findAll()

    @PostMapping
    fun createIou(@Valid @RequestBody transaction: IOU ) = IOURepository.save(transaction)


}
