package com.example.eclipsereads

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class Formulario_login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_formulario_login, container, false)

        // Referência do texto e botão
        val emailEditText = view.findViewById<EditText>(R.id.Email00)
        val senhaEditText = view.findViewById<EditText>(R.id.senha00)
        val entrarButton = view.findViewById<Button>(R.id.button2)

        // Botão desativado
        entrarButton.isEnabled = false

        // ver a mudança do texto
        val textWatcher = object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            // Ativa o botão quando cheios
            override fun afterTextChanged(s: android.text.Editable?) {
                val email = emailEditText.text.toString().trim()
                val senha = senhaEditText.text.toString().trim()
                entrarButton.isEnabled = email.isNotEmpty() && senha.isNotEmpty()
            }
        }

        // Aplica o verificador
        emailEditText.addTextChangedListener(textWatcher)
        senhaEditText.addTextChangedListener(textWatcher)

        // quando clica vai pro inicio
        entrarButton.setOnClickListener {
            val intent = Intent(requireContext(), Inicio::class.java)
            startActivity(intent)
        }

        return view
    }
}
