package com.example.eclipsereads

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class Formulario_registro : Fragment() {

    private lateinit var nomeEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var senhaEditText: EditText
    private lateinit var confirmarSenhaEditText: EditText
    private lateinit var button4: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // conecta o kt com o xml
        val view = inflater.inflate(R.layout.activity_formulario_registro, container, false)

        // Liga cada variável como o codigo xml
        nomeEditText = view.findViewById(R.id.Nome)
        emailEditText = view.findViewById(R.id.Email)
        senhaEditText = view.findViewById(R.id.Senha)
        confirmarSenhaEditText = view.findViewById(R.id.Confirmarsenha)
        button4 = view.findViewById(R.id.button4)

        // Desativa o botão temporariamente
        button4.isEnabled = false

        // Cria um detector de campo
        val formTextWatcher = object : TextWatcher {
            // Antes e depois da mudança de texto
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            // depois do texto mudar
            override fun afterTextChanged(s: Editable?) {

                // Pega o texto atual de cada campo e remove os espaços
                val nomeInput = nomeEditText.text.toString().trim()
                val emailInput = emailEditText.text.toString().trim()
                val senhaInput = senhaEditText.text.toString().trim()
                val confirmarSenhaInput = confirmarSenhaEditText.text.toString().trim()

                // Salva nome e e-mail do usuário e email
                salvarNomeUsuario(nomeInput)
                salvarEmailUsuario(emailInput)

                // Verifica se todos os campos estão preenchidos
                val camposPreenchidos = nomeInput.isNotEmpty() &&
                        emailInput.isNotEmpty() &&
                        senhaInput.isNotEmpty() &&
                        confirmarSenhaInput.isNotEmpty()

                // Verifica se as senhas batem
                val senhasCoincidem = senhaInput == confirmarSenhaInput

                // Ativa o botão quando estiverem preenchidos e as senhas batem
                button4.isEnabled = camposPreenchidos && senhasCoincidem

                // Mostra erro se as senhas não batem
                if (camposPreenchidos && !senhasCoincidem) {
                    confirmarSenhaEditText.error = "As senhas não batem"
                } else {
                    confirmarSenhaEditText.error = null
                }
            }
        }

        // coloca o observador
        nomeEditText.addTextChangedListener(formTextWatcher)
        emailEditText.addTextChangedListener(formTextWatcher)
        senhaEditText.addTextChangedListener(formTextWatcher)
        confirmarSenhaEditText.addTextChangedListener(formTextWatcher)

        //o que acontece quando clica no botão de registrar
        button4.setOnClickListener {
            // Cria uma intent pra abrir a tela Inicio
            val intent = Intent(requireContext(), Inicio::class.java)
            startActivity(intent)
        }
        return view
    }

    // salvar o nome do usuário nas preferências
    private fun salvarNomeUsuario(nome: String) {
        val sharedPreferences = requireActivity().getSharedPreferences("DADOS_USUARIO", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("NOME_USUARIO", nome)
        editor.apply()
    }

    // salvar o e-mail do usuário nas preferências
    private fun salvarEmailUsuario(email: String) {
        val sharedPreferences = requireActivity().getSharedPreferences("DADOS_USUARIO", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("EMAIL_USUARIO", email)
        editor.apply()
    }
}
