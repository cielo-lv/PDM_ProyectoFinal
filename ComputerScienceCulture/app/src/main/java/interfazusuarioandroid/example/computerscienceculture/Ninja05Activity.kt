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

class Ninja05Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ninja05)

        // Configurar enlaces
        findViewById<TextView>(R.id.link1).setOnClickListener {
            openLink("https://binariks.com/blog/ai-machine-learning-for-early-disease-detection/")
        }

        findViewById<TextView>(R.id.link2).setOnClickListener {
            openLink("https://www.siemens-healthineers.com/digital-health-solutions/artificial-intelligence-in-healthcare/ai-to-help-predict-disease")
        }

        findViewById<TextView>(R.id.link3).setOnClickListener {
            openLink("https://medium.com/@sofiekhan/cracking-the-code-how-machine-learning-is-detecting-diseases-early-on-c3d26ab28924")
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