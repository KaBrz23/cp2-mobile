package com.example.cp2

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Telefone : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telefone)
        val valorFixo = findViewById<EditText>(R.id.textoFixo)
        val valorEdit1 = findViewById<EditText>(R.id.textoValor1)
        val valorEdit2 = findViewById<EditText>(R.id.textoValor2)
        val BotaoCalc = findViewById<Button>(R.id.button)

        BotaoCalc.setOnClickListener {
            val taxa = valorFixo.text.toString().toDoubleOrNull()
            val valor1 = valorEdit1.text.toString().toDoubleOrNull()
            val valor2 = valorEdit2.text.toString().toDoubleOrNull()

            if (valor1 == null || valor2 == null || taxa == null) {
                Toast.makeText(this, "Os campos de valor são obrigatórios.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val resul1 = valor1 * 0.04
            val resul2 = valor2 * 0.20

            val intent = Intent(this, Resultado::class.java).apply {
                putExtra("taxa", taxa)
                putExtra("resultado1", resul1)
                putExtra("resultado2", resul2)
            }
            startActivity(intent)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}