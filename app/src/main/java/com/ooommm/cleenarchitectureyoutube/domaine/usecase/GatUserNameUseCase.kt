package com.ooommm.cleenarchitectureyoutube.domaine.usecase

import com.ooommm.cleenarchitectureyoutube.domaine.models.UserName
import com.ooommm.cleenarchitectureyoutube.domaine.repository.UserRepository

class GatUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        val userName = userRepository.getName()
        return userName
    }
}