package com.example.beinus.presentation.account_setting

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beinus.data.remote.model.User
import com.example.beinus.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountSettingViewModel @Inject constructor(
    private val service: Repository
) : ViewModel() {
    private val _userList = mutableStateOf<List<User>>(emptyList())
    val userList: State<List<User>> = _userList

    private val _userID = mutableStateOf("")
    val userID: State<String> = _userID

    private val _userPW = mutableStateOf("")
    val userPW: State<String> = _userPW

    private val _userPW2 = mutableStateOf("")
    val userPW2: State<String> = _userPW2

    fun getAllUsers() {
        viewModelScope.launch {
            _userList.value = service.getAllUsers()
        }
    }
    fun setUserID(id: String) {
        _userID.value = id
    }

    fun setUserPW(pw: String) {
        _userPW.value = pw
    }

    fun setUserPW2(pw2: String) {
        _userPW2.value = pw2
    }

    fun hasEmptyField(): Boolean {
        return userID.value.isEmpty() || userPW.value.isEmpty()
    }

    fun saveUser() {
        viewModelScope.launch {
            service.save(
                user = User(
                    userID.value,
                    userPW.value
                )
            )
        }
    }
}