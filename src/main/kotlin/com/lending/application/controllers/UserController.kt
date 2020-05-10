package com.lending.application.controllers

import com.lending.application.entity.User
import com.lending.application.repositories.IOURepository
import com.lending.application.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api/users")
class UserController(
    private val userRepository: UserRepository,
    private val IOURepository: IOURepository
) {

    /**
     * Gets a list of all users
     * @return List of users
     */
    @GetMapping
    fun getUsers(): List<User> = userRepository.findAllByOrderByFirstname()

    /**
     * Saves a user
     * @param user
     * @return a user DTO object
     */
    @PostMapping
    fun createUser(@Valid @RequestBody user: User): User = userRepository.save(user)

    /**
     * Gets a user by ID
     * @param userId
     * @return returns a user or not found response
     */
    @GetMapping("/{id}")
    fun getUserById(@PathVariable(value = "id") userId: Long): ResponseEntity<User> {
        return userRepository.findById(userId).map { user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }


    /**
     * Deletes a user with associated borrowers and lenders
     * @param userId
     * @return a response of the action
     */
    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Long): ResponseEntity<Void> {
        return userRepository.findById(userId).map { user ->
            userRepository.delete(user)
            // TODO to find a better way of deleting borrowers and lenders
            IOURepository.deleteAllByBorrower(user)
            IOURepository.deleteAllByLender(user)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }


}
