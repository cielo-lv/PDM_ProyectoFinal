package interfazusuarioandroid.example.computerscienceculture

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import interfazusuarioandroid.example.computerscienceculture.databinding.ActivityMainBinding
import interfazusuarioandroid.example.computerscienceculture.util.PreferenceHelper
import interfazusuarioandroid.example.computerscienceculture.util.PreferenceHelper.get
import interfazusuarioandroid.example.computerscienceculture.util.PreferenceHelper.set

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Verificar si ya hay una sesión activa
        val preferences = PreferenceHelper.defaultPrefs(this)
        if (preferences["session", false]) {
            val username = preferences["username", "User"]
            goToMenu(username)
        }

        // Listener del botón de login
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            when {
                username.isEmpty() -> {
                    binding.etUsername.error = "Enter username"
                    binding.etUsername.requestFocus()
                }
                password.isEmpty() -> {
                    binding.etPassword.error = "Enter password"
                    binding.etPassword.requestFocus()
                }
                else -> {
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                    goToMenu(username)
                }
            }
        }

    }

    private fun goToMenu(username: String) {
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"] = true
        preferences["username"] = username
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

}


