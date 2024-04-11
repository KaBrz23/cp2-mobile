package com.example.cp2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Resultado : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resultado)

        val taxa = intent.getDoubleExtra("taxa", 0.0)
        val resul1 = intent.getDoubleExtra("resultado1", 0.0)
        val resul2 = intent.getDoubleExtra("resultado2", 0.0)

        val total = taxa + resul1 + resul2

        val resultadoView = findViewById<TextView>(R.id.resultado)
        resultadoView.text = String.format("Taxa: \t\t R$ %.2f\n" +
                "Chamada Local: \t\t R$ %.2f\n" +
                "Chamada Celular: \t\t R$ %.2f\n\n" +
                "Total: R$ %.2f", taxa, resul1, resul2, total)

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