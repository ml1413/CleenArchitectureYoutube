package com.ooommm.cleenarchitectureyoutube.data.repository

import com.ooommm.cleenarchitectureyoutube.data.storage.UserStorage
import com.ooommm.cleenarchitectureyoutube.data.storage.models.User
import com.ooommm.cleenarchitectureyoutube.domaine.models.SaveUserNameParam
import com.ooommm.cleenarchitectureyoutube.domaine.models.UserName
import com.ooommm.cleenarchitectureyoutube.domaine.repository.UserRepository


class UserRepositoryImpl(
    private val userStorage: UserStorage
) : UserRepository {


    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        val userName = mapToDomain(user)
        return userName
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        val user = User(firstName = saveParam.firstName, lastName = "")
        return user
    }

    private fun mapToDomain(user: User): UserName {
        val userName = UserName(firstName = user.firstName, lastName = user.lastName)
        return userName
    }
}