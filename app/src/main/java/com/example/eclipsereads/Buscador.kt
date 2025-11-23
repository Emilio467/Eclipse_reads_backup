package com.example.eclipsereads

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import android.content.Intent
import android.widget.ImageView


class Buscador : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscador)

        val searchViewWidget: androidx.appcompat.widget.SearchView =
            findViewById(R.id.search_view_no_layout)
        searchViewWidget.queryHint = "Buscar livros..."
        searchViewWidget.isIconified = false

        searchViewWidget.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    Log.d("BuscadorActivity", "Busca submetida: $query")
                }
                searchViewWidget.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    Log.d("BuscadorActivity", "Texto mudou: $newText")
                }
                return true
            }
        })


        // Menu
        findViewById<ImageView>(R.id.Buscar).setOnClickListener {
            startActivity(Intent(this, Inicio::class.java))
        }
        findViewById<ImageView>(R.id.buscar0).setOnClickListener {
            startActivity(Intent(this, Buscador::class.java))
        }
        findViewById<ImageView>(R.id.buscar00).setOnClickListener {
            startActivity(Intent(this, Minhabiblio::class.java))
        }
        findViewById<ImageView>(R.id.buscar000).setOnClickListener {
            startActivity(Intent(this, Configuracoes::class.java))
        }
        findViewById<ImageView>(R.id.buscar0000).setOnClickListener {
            startActivity(Intent(this, Perfil::class.java))
        }

        // Botões para entrar na info_livro
        findViewById<ImageView>(R.id.imageView50).setOnClickListener {
            startActivity(Intent(this, Info_livro::class.java))
        }
        findViewById<ImageView>(R.id.imageView5).setOnClickListener {
            startActivity(Intent(this, Info_livro::class.java))
        }
    }
}
