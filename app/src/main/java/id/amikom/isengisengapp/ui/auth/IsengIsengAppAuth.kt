package id.amikom.isengisengapp.ui.auth

import android.content.Context
import id.amikom.isengisengapp.data.model.ActionState
import id.amikom.isengisengapp.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object IsengIsengAppAuth {

    fun logout(context: Context, callbacks: ((ActionState<Boolean>)-> Unit)? = null){
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main){
                if(callbacks != null) callbacks.invoke(resp)
            }
        }
    }
}