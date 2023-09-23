package com.rn.basico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rn.basico.databinding.ActivityTela2Binding

class Tela2Activity : AppCompatActivity() {
    private lateinit var bindingTela2: ActivityTela2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingTela2 = ActivityTela2Binding.inflate(layoutInflater)
        setContentView(bindingTela2.root)

        val nome = intent.getStringExtra("nome")
        val idade = intent.getIntExtra("idade", -1)
        bindingTela2.textMensagem.text = "Nome: $nome / Idade: $idade"

        val cliente= intent.getParcelableExtra<Cliente>("cliente")
        val pessoa = intent.getSerializableExtra("pessoa")as Pessoa?//O objeto pessoa pode ser nulo

        bindingTela2.textMensagem.text = (if(cliente != null){
            getString(R.string.tela2_texto1, cliente.nome, cliente.codigo)
        } else if(pessoa != null){
            getString(R.string.tela2_texto2, pessoa.nome, pessoa.idade)
        }else{
            getString(R.string.tela2_texto2, nome, idade)
        }).toString()

    }
}