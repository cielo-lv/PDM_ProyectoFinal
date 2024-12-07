package interfazusuarioandroid.example.computerscienceculture

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RobotsDashboardActivity : AppCompatActivity() {

    private lateinit var unoCard: CardView
    private lateinit var dosCard: CardView
    private lateinit var tresCard: CardView
    private lateinit var cuatroCard: CardView
    private lateinit var cincoCard: CardView
    private lateinit var seisCard: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_robots_dashboard)

        // Configuramos las opciones de navegación o cards de la app
        unoCard = findViewById(R.id.unoCard)
        dosCard = findViewById(R.id.dosCard)
        tresCard = findViewById(R.id.tresCard)
        cuatroCard = findViewById(R.id.cuatroCard)
        cincoCard = findViewById(R.id.cincoCard)
        seisCard = findViewById(R.id.seisCard)

        // Acción al hacer click
        unoCard.setOnClickListener {
            val intent = Intent(this, Robots01Activity::class.java)
            startActivity(intent)
        }
        dosCard.setOnClickListener {
            val intent = Intent(this, Robots02Activity::class.java)
            startActivity(intent)
        }
        tresCard.setOnClickListener {
            val intent = Intent(this, Robots03Activity::class.java)
            startActivity(intent)
        }
        cuatroCard.setOnClickListener {
            val intent = Intent(this, Robots04Activity::class.java)
            startActivity(intent)
        }
        cincoCard.setOnClickListener {
            val intent = Intent(this, Robots05Activity::class.java)
            startActivity(intent)
        }
        seisCard.setOnClickListener {
            val intent = Intent(this, Robots06Activity::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}