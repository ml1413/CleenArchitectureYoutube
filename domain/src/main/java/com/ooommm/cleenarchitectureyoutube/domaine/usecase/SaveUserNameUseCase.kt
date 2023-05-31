package com.ooommm.cleenarchitectureyoutube.domaine.usecase

import com.ooommm.cleenarchitectureyoutube.domaine.models.SaveUserNameParam
import com.ooommm.cleenarchitectureyoutube.domaine.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(params: SaveUserNameParam): Boolean {
        return userRepository.saveName(saveParam = params)
    }
}