package com.ooommm.cleenarchitectureyoutube.data.storage.sharedprefs

import android.content.Context
import com.ooommm.cleenarchitectureyoutube.data.storage.UserStorage
import com.ooommm.cleenarchitectureyoutube.data.storage.models.User

private const val SHARED_PREFS_NAME = "shared_prefs_name"

private const val KEY_FIRST_NAME = "key_first_name"
private const val KEY_LAST_NAME = "key_last_name"
private const val DEF_FIRST_NAME = "default_first_name"
private const val DEF_LAST_NAME = "default_last_name"

class SharedPrepUserStorage(context: Context) : UserStorage {


    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName =
            sharedPreferences.getString(KEY_FIRST_NAME, DEF_FIRST_NAME) ?: DEF_FIRST_NAME
        val lastName =
            sharedPreferences.getString(KEY_LAST_NAME, DEF_LAST_NAME) ?: DEF_LAST_NAME
        return User(firstName = firstName, lastName = lastName)
    }
}