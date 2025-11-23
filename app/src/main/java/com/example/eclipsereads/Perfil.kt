package com.example.eclipsereads

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Perfil : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
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
        //botão minha biblioteca
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
        // Pegar dados da tela log0regis (login e registro)
        // Pega o texto que é o nome do usuario.
        val textViewNomePerfil = findViewById<TextView>(R.id.textView23)
        // Pega o texto do email do usuario.
        val textViewEmailPerfil = findViewById<TextView>(R.id.textView24)
       // pega o texto compartilhado na outra tela
        val sharedPreferences = getSharedPreferences("DADOS_USUARIO", Context.MODE_PRIVATE)

        // Caso não tenha um nome salvo, o nome será Usuário
        val nomeSalvo = sharedPreferences.getString("NOME_USUARIO", "Usuário")

        // Pega o email do usuario e se não tiver, será email não informado.
        val emailSalvo = sharedPreferences.getString("EMAIL_USUARIO", "E-mail não informado")

        // Define o texto e o salva
        textViewNomePerfil.text = nomeSalvo

        // Define o texto e o salva
        textViewEmailPerfil.text = emailSalvo

    }
}
