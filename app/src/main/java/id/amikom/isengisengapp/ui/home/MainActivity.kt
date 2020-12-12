package id.amikom.isengisengapp.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import id.amikom.isengisengapp.R
import id.amikom.isengisengapp.databinding.ActivityMainBinding
import id.amikom.isengisengapp.ui.auth.AuthActivity
import id.amikom.isengisengapp.ui.auth.IsengIsengAppAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonLogout.setOnClickListener {
            IsengIsengAppAuth.logout(this){
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
    }
}