package com.lending.application.repositories

import com.lending.application.entity.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class UserRepositoryTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository
){

    @Test
    fun `When findAllByOrderByFirstname returns users in Ascending order`() {
        val juergen = User(null, "Juergen", "Hoeller")
        entityManager.persist(juergen)
        val bob = User(null, "Bob", "Hetinga")
        entityManager.persist(bob)
        entityManager.flush()
        val users = userRepository.findAllByOrderByFirstname()
        assertThat(users.first()).isEqualTo(bob)
    }
}
