package interfazusuarioandroid.example.computerscienceculture

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.cardview.widget.CardView
import android.content.Context
import android.content.SharedPreferences
import android.widget.Button
import interfazusuarioandroid.example.computerscienceculture.util.PreferenceHelper
import interfazusuarioandroid.example.computerscienceculture.util.PreferenceHelper.set
import interfazusuarioandroid.example.computerscienceculture.util.PreferenceHelper.get


class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView // Declarar navigationView como miembro de clase
    private lateinit var ciberhistoriaCard: CardView
    private lateinit var creativeCard: CardView
    private lateinit var eticaCard: CardView
    private lateinit var ninjaCard: CardView
    private lateinit var robotsCard: CardView
    private lateinit var cultureCard: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Verificar si hay una sesión activa
        val preferences = PreferenceHelper.defaultPrefs(this)
        // Obtener el nombre del usuario desde el Intent
        val username = preferences["username", intent.getStringExtra("username") ?: "User"] // Recupera el nombre guardado



        setContentView(R.layout.activity_home)

        // Configurar Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Mostrar el nombre del usuario en la barra superior
        supportActionBar?.title = "Holaa, $username !!"

        // Para logout
        val btnLogout = findViewById<Button>(R.id.btn_logout)
        btnLogout.setOnClickListener{
            clearSessionPreference()
            goToLogin()
        }

        // Configurar NavigationDrawer
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView) // Inicializar navigationView
        navigationView.setNavigationItemSelectedListener(this)

        // Configurar el ícono del DrawerToggle
        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Recuperar la última sección visitada
        val sharedPreferences: SharedPreferences = getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        val lastSection = sharedPreferences.getString("last_section", null)

        // Redirigir automáticamente si hay una sección previa
        when (lastSection) {
            "CiberHistoria" -> {
                val intent = Intent(this, HistoryDashboardActivity::class.java)
                startActivity(intent)
            }
            "Código Creativo" -> {
                val intent = Intent(this, CreativeDashboardActivity::class.java)
                startActivity(intent)
            }
            "Ética Tech" -> {
                val intent = Intent(this, EticaDashboardActivity::class.java)
                startActivity(intent)
            }
            "Software Ninja" -> {
                val intent = Intent(this, NinjaDashboardActivity::class.java)
                startActivity(intent)
            }
            "Robots" -> {
                val intent = Intent(this, RobotsDashboardActivity::class.java)
                startActivity(intent)
            }
            "Cultura Coder" -> {
                val intent = Intent(this, CultureDashboardActivity::class.java)
                startActivity(intent)
            }
        }


        // Configurar el botón de cierre en el header del Navigation Drawer
        val headerView = navigationView.getHeaderView(0) // Obtener la vista del header
        val closeButton = headerView.findViewById<ImageButton>(R.id.btn_close_drawer)
        closeButton.setOnClickListener {
            drawerLayout.closeDrawer(GravityCompat.START) // Cerrar el Drawer
        }


        // Configuramos las opciones de navegación o cards de la app
        ciberhistoriaCard = findViewById(R.id.ciberhistoriaCard)
        creativeCard = findViewById(R.id.creativeCard)
        eticaCard = findViewById(R.id.eticaCard)
        ninjaCard = findViewById(R.id.ninjaCard)
        robotsCard = findViewById(R.id.robotsCard)
        cultureCard = findViewById(R.id.cultureCard)

        // Acción al hacer click
        ciberhistoriaCard.setOnClickListener {
            val intent = Intent(this, HistoryDashboardActivity::class.java)
            startActivity(intent)
        }
        creativeCard.setOnClickListener {
            val intent = Intent(this, CreativeDashboardActivity::class.java)
            startActivity(intent)
        }
        eticaCard.setOnClickListener {
            val intent = Intent(this, EticaDashboardActivity::class.java)
            startActivity(intent)
        }
        ninjaCard.setOnClickListener {
            val intent = Intent(this, NinjaDashboardActivity::class.java)
            startActivity(intent)
        }
        robotsCard.setOnClickListener {
            val intent = Intent(this, RobotsDashboardActivity::class.java)
            startActivity(intent)
        }
        cultureCard.setOnClickListener {
            val intent = Intent(this, CultureDashboardActivity::class.java)
            startActivity(intent)
        }


    }

    // Inflar el menú de opciones (tres puntitos)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return true
    }


    // Manejar los clics en las opciones del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "Settings seleccionado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_help -> {
                Toast.makeText(this, "Help seleccionado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_about -> {
                Toast.makeText(this, "About seleccionado", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                if (toggle.onOptionsItemSelected(item)) {
                    true
                } else {
                    super.onOptionsItemSelected(item)
                }
            }
        }
    }

    // Manejar clics en el menú lateral
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        // Obtener instancia de SharedPreferences
        val sharedPreferences: SharedPreferences = getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        when (item.itemId) {
            R.id.nav_home -> {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                editor.putString("last_section", "Home")
            }
            R.id.nav_ciberhistoria -> {
                val intent = Intent(this, HistoryDashboardActivity::class.java)
                startActivity(intent)
                editor.putString("last_section", "CiberHistoria")
            }
            R.id.nav_codigocreativo -> {
                val intent = Intent(this, CreativeDashboardActivity::class.java)
                startActivity(intent)
                editor.putString("last_section", "Código Creativo")
            }
            R.id.nav_etica -> {
                val intent = Intent(this, EticaDashboardActivity::class.java)
                startActivity(intent)
                editor.putString("last_section", "Ética Tech")
            }
            R.id.nav_softninja -> {
                val intent = Intent(this, NinjaDashboardActivity::class.java)
                startActivity(intent)
                editor.putString("last_section", "Software Ninja")
            }
            R.id.nav_robots -> {
                val intent = Intent(this, RobotsDashboardActivity::class.java)
                startActivity(intent)
                editor.putString("last_section", "Robots")
            }
            R.id.nav_culturacoder -> {
                val intent = Intent(this, CultureDashboardActivity::class.java)
                startActivity(intent)
                editor.putString("last_section", "Cultura Coder")
            }
        }
        editor.apply() // Guardar cambios en SharedPreferences
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    // Manejar el botón "Back"
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun clearSessionPreference() {
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"] = false
    }

    private fun goToLogin() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}




