package interfazusuarioandroid.example.computerscienceculture

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HistoryDashboardActivity : AppCompatActivity() {

    private lateinit var adaLovelaceCard: CardView
    private lateinit var hedyLamarrCard: CardView
    private lateinit var graceHopperCard: CardView
    private lateinit var marchCard: CardView
    private lateinit var feiCard: CardView
    private lateinit var barbaraLiskovCard: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_dashboard)


        // Configuramos las opciones de navegación o cards de la app
        adaLovelaceCard = findViewById(R.id.adaLovelaceCard)
        hedyLamarrCard = findViewById(R.id.hedyLamarrCard)
        graceHopperCard = findViewById(R.id.graceHopperCard)
        marchCard = findViewById(R.id.marchCard)
        feiCard = findViewById(R.id.feiCard)
        barbaraLiskovCard = findViewById(R.id.barbaraLiskovCard)

        // Acción al hacer click
        adaLovelaceCard.setOnClickListener {
            val intent = Intent(this, History01Activity::class.java)
            startActivity(intent)
        }
        hedyLamarrCard.setOnClickListener {
            val intent = Intent(this, History02Activity::class.java)
            startActivity(intent)
        }
        graceHopperCard.setOnClickListener {
            val intent = Intent(this, History03Activity::class.java)
            startActivity(intent)
        }
        marchCard.setOnClickListener {
            val intent = Intent(this, History04Activity::class.java)
            startActivity(intent)
        }
        feiCard.setOnClickListener {
            val intent = Intent(this, History05Activity::class.java)
            startActivity(intent)
        }
        barbaraLiskovCard.setOnClickListener {
            val intent = Intent(this, History06Activity::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}