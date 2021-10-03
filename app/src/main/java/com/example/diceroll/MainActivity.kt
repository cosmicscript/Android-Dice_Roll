package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
            Toast.makeText(this, "Dice rolled", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollDice() {
        val firstDice = Dice(6)
        val resultTextView = findViewById<TextView>(R.id.textView)
        resultTextView.text = firstDice.roll().toString()

        val dice = Dice(20)
        val diceVal = dice.roll()

        val findViewById = findViewById<TextView>(R.id.textView2)
        findViewById.text = diceVal.toString()
    }
}

class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}