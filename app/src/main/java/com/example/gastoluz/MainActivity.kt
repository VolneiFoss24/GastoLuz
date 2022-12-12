package com.example.gastoluz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastoluz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        calcular()
    }

    private fun validate(): Boolean {
        return (
                binding.editWatss.text.toString() != "" &&
                        binding.editTempo.text.toString() != "" &&
                        binding.editTarifa.text.toString() != "" &&
                        binding.editTempo.text.toString().toFloat() != 0f
                )
    }

    private fun calcular() {
        if (validate()) {
            val watts = binding.editWatss.text.toString().toFloat()
            val tempo = binding.editTempo.text.toString().toFloat()
            val tarifa = binding.editTarifa.text.toString().toFloat()

            val toKwh = (watts * tempo) / 1000
            val precoFinal = toKwh * tarifa
            binding.textResposta.text = "1 Dia : R$ ${"%.2f".format(precoFinal)}"
            binding.textRespostaMes.text = "30 Dias : R$ ${"%.2f".format(precoFinal * 30)}"
        } else {
            Toast.makeText(this, getString(R.string.preencher_campos), Toast.LENGTH_SHORT).show()
        }
    }
}