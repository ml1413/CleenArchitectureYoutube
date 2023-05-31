package com.ooommm.cleenarchitectureyoutube.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ooommm.cleenarchitectureyoutube.data.repository.UserRepositoryImpl
import com.ooommm.cleenarchitectureyoutube.data.storage.sharedprefs.SharedPrepUserStorage
import com.ooommm.cleenarchitectureyoutube.databinding.ActivityMainBinding
import com.ooommm.cleenarchitectureyoutube.domaine.models.SaveUserNameParam
import com.ooommm.cleenarchitectureyoutube.domaine.models.UserName
import com.ooommm.cleenarchitectureyoutube.domaine.usecase.GatUserNameUseCase
import com.ooommm.cleenarchitectureyoutube.domaine.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userStorage by lazy(LazyThreadSafetyMode.NONE)
    { SharedPrepUserStorage(context = applicationContext) }

    private val userRepository by lazy(LazyThreadSafetyMode.NONE)
    { UserRepositoryImpl(userStorage = userStorage) }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE)
    { GatUserNameUseCase(userRepository) }

    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE)
    { SaveUserNameUseCase(userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.btSendButton.setOnClickListener {
            val text = binding.etDataText.text.toString()
            val params = SaveUserNameParam(firstName = text)
            val result = saveUserNameUseCase.execute(params = params)
            binding.tvDataText.text = "Save result = $result"
        }

        binding.btReceiveButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            binding.tvDataText.text = "${userName.firstName}  ${userName.lastName}"
        }

    }
}