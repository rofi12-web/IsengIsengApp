package id.amikom.isengisengapp.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import id.amikom.isengisengapp.R
import id.amikom.isengisengapp.data.model.AuthUser
import id.amikom.isengisengapp.databinding.ActivityAuthBinding
import id.amikom.isengisengapp.ui.home.MainActivity

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
    }

    fun onSuccess(user: AuthUser?) {
    val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}