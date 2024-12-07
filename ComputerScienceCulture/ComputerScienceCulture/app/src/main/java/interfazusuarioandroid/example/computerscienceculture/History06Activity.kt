package interfazusuarioandroid.example.computerscienceculture

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class History06Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_history06)

        //Enlaces
        findViewById<TextView>(R.id.link1).setOnClickListener {
            openLink("https://mujeresconciencia.com/2017/11/07/barbara-liskov-especialista-ciencias-la-computacion/")
        }

        findViewById<TextView>(R.id.link2).setOnClickListener {
            openLink("https://jala.university/blog/2024/07/18/barbara-liskov-su-aporte-en-el-diseno-de-software/")
        }

        findViewById<TextView>(R.id.link3).setOnClickListener {
            openLink("https://sistemas.uniandes.edu.co/images/forosisis/revista/2/pdf/ForosISIS_N02_36_Barbara-Liskov-pionera-de-la-computacion-moderna.pdf")
        }

        findViewById<TextView>(R.id.link4).setOnClickListener {
            openLink("https://www.youtube.com/watch?v=_jTc1BTFdIo")
        }


        // Botón "Agregar a biblioteca"
        findViewById<Button>(R.id.add_to_library_button).setOnClickListener {
            addToLibrary()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun addToLibrary() {
        // Lógica para agregar a la "biblioteca" (puede ser almacenamiento interno o base de datos)
        Toast.makeText(this, "Agregado a la biblioteca", Toast.LENGTH_SHORT).show()
    }
}