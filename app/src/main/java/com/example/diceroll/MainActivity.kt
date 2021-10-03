package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val imageView : ImageView = findViewById(R.id.imageView)
        rollButton.setOnClickListener {
            rollTheDice(6, imageView)
            Toast.makeText(this, "Dice rolled", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollTheDice(sides: Int, imageView: ImageView) {
        val firstDice = Dice(sides)
        val diceVal = firstDice.roll()
        val imageSrc = when (diceVal) {
            1 -> (R.drawable.dice_1)
            2 -> (R.drawable.dice_2)
            3 -> (R.drawable.dice_3)
            4 -> (R.drawable.dice_4)
            5 -> (R.drawable.dice_5)
            else -> (R.drawable.dice_6)
        }
        imageView.contentDescription = diceVal.toString()
        imageView.setImageResource(imageSrc)
    }
}

class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}