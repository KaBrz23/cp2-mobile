package com.example.cp2


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import android.content.Intent


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val BotaoCalc = findViewById<Button>(R.id.BotaoCalc)
        val BotaoTelefone = findViewById<Button>(R.id.BotaoTelefone)
        val BotaoAluno = findViewById<Button>(R.id.BotaoAluno)

        BotaoCalc.setOnClickListener {
            val intent = Intent(this, Calculadora::class.java)
            startActivity(intent)
        }
        BotaoTelefone.setOnClickListener {
            val intent = Intent(this, Telefone::class.java)
            startActivity(intent)
        }
        BotaoAluno.setOnClickListener {
            Assinatura()
        }
    }

    private fun Assinatura() {
        val mySignature = """
            Nome: Kauê Braz
            RM: 97768
        """.trimIndent()

        AlertDialog.Builder(this)
            .setTitle("Desenvolvido Por:")
            .setMessage(mySignature)
            .setPositiveButton("Ok") { dialog, which -> }
            .show()
    }
}