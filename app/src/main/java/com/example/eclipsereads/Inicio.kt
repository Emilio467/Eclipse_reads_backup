package com.example.eclipsereads

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Inicio : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)




           //botão inicio
            val btnInicio = findViewById<ImageView>(R.id.Buscar)
            btnInicio.setOnClickListener {
                val intent = Intent(this, Inicio::class.java)
                startActivity(intent)
            }
            //botão buscar
            val btnBuscar = findViewById<ImageView>(R.id.buscar0)
            btnBuscar.setOnClickListener {
                val intent = Intent(this, Buscador::class.java)
                startActivity(intent)
            }
            //botão biblioteca
            val btnBiblioteca = findViewById<ImageView>(R.id.buscar00)
            btnBiblioteca.setOnClickListener {
                val intent = Intent(this, Minhabiblio::class.java)
                startActivity(intent)
            }
            //botão configurações
            val btnConfig = findViewById<ImageView>(R.id.buscar000)
            btnConfig.setOnClickListener {
                val intent = Intent(this, Configuracoes::class.java)
                startActivity(intent)
            }
            //botão perfil
            val btnPerfil = findViewById<ImageView>(R.id.buscar0000)
            btnPerfil.setOnClickListener {
                val intent = Intent(this, Perfil::class.java)
                startActivity(intent)
            }

            //botão livro1
            val btninicial3 = findViewById<ImageView>(R.id.imageView500)
            btninicial3.setOnClickListener {
                val intent = Intent(this, Info_livro::class.java)
                startActivity(intent)
            }





insets
        }
    }
}

