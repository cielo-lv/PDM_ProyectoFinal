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

class History05Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_history05)

        //Enlaces
        findViewById<TextView>(R.id.link1).setOnClickListener {
            openLink("https://es.wired.com/articulos/fei-fei-li-madrina-de-ia-quiere-que-todos-seamos-constructores-de-mundos")
        }

        findViewById<TextView>(R.id.link2).setOnClickListener {
            openLink("https://www.fundacionaquae.org/fei-fei-li-pionera-de-la-inteligencia-artificial-y-del-uso-etico-de-esta-tecnologia/")
        }

        findViewById<TextView>(R.id.link3).setOnClickListener {
            openLink("https://forbes.com.mx/madrina-de-la-ia-fei-fei-li-recauda-230-mdd-para-lanzar-una-startup-de-ia/")
        }

        findViewById<TextView>(R.id.link4).setOnClickListener {
            openLink("https://www.youtube.com/watch?v=y8NtMZ7VGmU")
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