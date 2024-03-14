package com.example.beinus.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beinus.data.remote.model.Employee
import com.example.beinus.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val service: Repository
) : ViewModel() {
    private val _name = mutableStateOf("")
    val name: State<String> = _name

    private val _branch = mutableStateOf("")
    val branch: State<String> = _branch

    private val _location = mutableStateOf<String>("")
    val location: State<String> = _location
    fun setName(name: String) {
        _name.value = name
    }

    fun setBranch(branch: String) {
        _branch.value = branch
    }

    fun setLocation(location: String) {
        _location.value = location
    }

    fun haveEmptyField(): Boolean {
        return name.value.isEmpty() || branch.value.isEmpty() || location.value.isEmpty()
    }

    fun saveEmployee() {
        viewModelScope.launch {
            service.save(
                employee = Employee(
                    name.value,
                    location.value,
                    branch.value
                )
            )
        }
    }
}