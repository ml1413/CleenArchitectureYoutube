package com.ooommm.cleenarchitectureyoutube.data.storage

import com.ooommm.cleenarchitectureyoutube.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User
}