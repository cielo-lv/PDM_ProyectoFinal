package interfazusuarioandroid.example.computerscienceculture

import android.content.Intent
import android.net.Uri
import android.os.Bundle
// import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class History01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_history01)


        // Configurar enlaces
        findViewById<TextView>(R.id.link1).setOnClickListener {
            openLink("https://historia.nationalgeographic.com.es/a/ada-lovelace-visionaria-hija-lord-byron_15864")
        }

        findViewById<TextView>(R.id.link2).setOnClickListener {
            openLink("https://www.fundacionaquae.org/wiki/ada-lovelace-madre-de-la-programacion/")
        }

        findViewById<TextView>(R.id.link3).setOnClickListener {
            openLink("https://www.mncn.csic.es/es/visita-el-mncn/biografia-de-ada-lovelace")
        }

        findViewById<TextView>(R.id.link4).setOnClickListener {
            openLink("https://www.nytimes.com/es/2018/03/10/espanol/cultura/ada-lovelace-obituario-overlooked.html")
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