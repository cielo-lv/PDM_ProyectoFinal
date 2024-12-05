package interfazusuarioandroid.example.computerscienceculture

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import interfazusuarioandroid.example.computerscienceculture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Variable para el View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configuración de View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Listener para el botón de login
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            // Validaciones de los campos
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
                    // Validación exitosa: muestra un Toast (o navega al siguiente dashboard)
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

                    //
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("username", username) // Pasar el nombre de usuario
                    startActivity(intent)
                }
            }
        }
    }
}



