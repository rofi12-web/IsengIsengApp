package id.amikom.isengisengapp.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.amikom.isengisengapp.data.model.ActionState
import id.amikom.isengisengapp.data.model.AuthUser
import id.amikom.isengisengapp.data.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(val repo: AuthRepository) : ViewModel() {
    val authUser = repo.authUser
    val isLogin = repo.isLogin
    val authLogin = MutableLiveData<ActionState<AuthUser>>()
    val authReg = MutableLiveData<ActionState<AuthUser>>()
    val authLogout = MutableLiveData<ActionState<Boolean>>()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val fullname = MutableLiveData<String>()


    fun login() {
        viewModelScope.launch {
            val resp = repo.login(email.value ?: "", password.value ?: "")
            authLogin.value = resp
        }
    }

    fun reg() {
        viewModelScope.launch {
            val resp = repo.reg(
                AuthUser(
                    email = email.value ?: "",
                    password = password.value ?: "",
                    fullname = fullname.value ?: ""
                )
            )
            authReg.value = resp

        }
        fun logout(){
            viewModelScope.launch {
                val resp = repo.logout()
                authLogout.value = resp
            }
        }
    }

}