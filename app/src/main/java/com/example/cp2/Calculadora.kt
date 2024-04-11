package com.example.cp2


import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.calculadora)

        val edit1 = findViewById<EditText>(R.id.textoValor1)
        val Edit2 = findViewById<EditText>(R.id.textoValor2)
        val operacao = findViewById<RadioGroup>(R.id.radioGroup)
        val Calc = findViewById<Button>(R.id.button)

        Calc.setOnClickListener {
            val valor1 = edit1.text.toString().toDoubleOrNull()
            val valor2 = Edit2.text.toString().toDoubleOrNull()
            if (valor1 == null || valor2 == null) {
                Toast.makeText(this, "Os valores são necessários.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val resultado = when (operacao.checkedRadioButtonId) {
                R.id.Soma -> valor1 + valor2
                R.id.Multiplicacao -> valor1 * valor2
                R.id.Subtracao -> valor1 - valor2
                R.id.Divisao -> if (valor2 != 0.0) {
                    valor1/valor2
                } else "Não é possível fazer divisão por zero"
                else -> null
            }
            if (resultado == null) {
                Toast.makeText(this, "Operação inválida", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Resultado: $resultado", Toast.LENGTH_SHORT).show()
            }
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