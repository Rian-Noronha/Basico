package com.rn.basico
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rn.basico.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToast.setOnClickListener{
            val texto = binding.editTexto.text.toString()
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
        }

        binding.buttonTela2.setOnClickListener{
            val intent = Intent(this,Tela2Activity::class.java)
            intent.putExtra("nome", "Rian")
            intent.putExtra("idade", 22)
            startActivity(intent)
        }

        binding.buttonParcel.setOnClickListener{
            val cliente = Cliente(1, "Rian")
            val intent = Intent(this, Tela2Activity::class.java)
            intent.putExtra("cliente", cliente)
            startActivity(intent)

        }

        binding.buttonSerializable.setOnClickListener{
            val intent = Intent(this, Tela2Activity::class.java)
            val pessoa = Pessoa("Ana", 42)
            intent.putExtra("pessoa", pessoa)
            startActivity(intent)
        }

    }
}