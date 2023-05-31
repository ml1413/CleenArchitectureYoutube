package com.ooommm.cleenarchitectureyoutube.domaine.repository

import com.ooommm.cleenarchitectureyoutube.domaine.models.SaveUserNameParam
import com.ooommm.cleenarchitectureyoutube.domaine.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean
    fun getName(): UserName
}