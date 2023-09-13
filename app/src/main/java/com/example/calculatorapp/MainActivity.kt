package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var cont:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById<Button>(R.id.buttonNum7)
        val text: TextView = findViewById<TextView>(R.id.textViewNumbers)

        button.setOnClickListener {
            cont =+1
            text.text = cont.toString()
        }

    }

    override fun onResume(){
        super.onResume()
        Log.d("Debug","onResume")
        val text: TextView = findViewById(R.id.textViewNumbers)
        text.text = cont.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save the user's current game state.
        outState?.run {
            putInt("contador", cont)
        }
        // Always call the superclass so it can save the view hierarchy.
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Always call the superclass so it can restore the view hierarchy.
        super.onRestoreInstanceState(savedInstanceState)
        // Restore state members from saved instance.
        savedInstanceState?.run {
            cont = savedInstanceState.getInt("contador")
        }
    }

}