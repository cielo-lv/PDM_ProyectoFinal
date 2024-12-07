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

class History02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history02)

        //Enlaces
        findViewById<TextView>(R.id.link1).setOnClickListener {
            openLink("https://historia.nationalgeographic.com.es/a/hedy-lamarr-prodigiosa-inventora-eclipsada-por-su-fama-hollywood_14882")
        }

        findViewById<TextView>(R.id.link2).setOnClickListener {
            openLink("https://mujeresconciencia.com/2015/11/30/hedy-lamarr-la-inventora/")
        }

        findViewById<TextView>(R.id.link3).setOnClickListener {
            openLink("https://www.teltronic.es/hedy-lamarr-la-actriz-que-dejo-huella-en-hollywood-y-en-la-historia-de-las-telecomunicaciones/")
        }

        findViewById<TextView>(R.id.link4).setOnClickListener {
            openLink("https://centroculturadigital.mx/revista/hedy-lamarr")
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