package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var result:String? = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var operation:String = ""
        val text: TextView = findViewById<TextView>(R.id.textViewNumbers)

        val buttonN1: Button = findViewById<Button>(R.id.buttonNum1)
        val buttonN2: Button = findViewById<Button>(R.id.buttonNum2)
        val buttonN3: Button = findViewById<Button>(R.id.buttonNum3)
        val buttonN4: Button = findViewById<Button>(R.id.buttonNum4)
        val buttonN5: Button = findViewById<Button>(R.id.buttonNum5)
        val buttonN6: Button = findViewById<Button>(R.id.buttonNum6)
        val buttonN7: Button = findViewById<Button>(R.id.buttonNum7)
        val buttonN8: Button = findViewById<Button>(R.id.buttonNum8)
        val buttonN9: Button = findViewById<Button>(R.id.buttonNum9)
        val buttonN0: Button = findViewById<Button>(R.id.buttonNum0)

        val buttonPls: Button = findViewById<Button>(R.id.buttonPlus)
        val buttonMin: Button = findViewById<Button>(R.id.buttonMinus)
        val buttonEq: Button = findViewById<Button>(R.id.buttonEqual)

        buttonN1.setOnClickListener {
            operation += "1"
            result=operation
            text.text = result.toString()
        }

        buttonN2.setOnClickListener {
            operation += "2"
            result=operation
            text.text = result.toString()
        }

        buttonN3.setOnClickListener {
            operation += "3"
            result=operation
            text.text = result.toString()
        }

        buttonN4.setOnClickListener {
            operation += "4"
            result=operation
            text.text = result.toString()
        }

        buttonN5.setOnClickListener {
            operation += "5"
            result=operation
            text.text = result.toString()
        }

        buttonN6.setOnClickListener {
            operation += "6"
            result=operation
            text.text = result.toString()
        }

        buttonN7.setOnClickListener {
            operation += "7"
            result=operation
            text.text = result.toString()
        }

        buttonN8.setOnClickListener {
            operation += "8"
            result=operation
            text.text = result.toString()
        }

        buttonN9.setOnClickListener {
            operation += "9"
            result=operation
            text.text = result.toString()
        }

        buttonN0.setOnClickListener {
            operation += "0"
            result=operation
            text.text = result.toString()
        }

        buttonPls.setOnClickListener {
            if (operation.isNotEmpty()) {
                operation = "$operation+"
                text.text = operation.toString()
            }
        }
        buttonMin.setOnClickListener {
            operation = "$operation-"
            text.text = operation.toString()
        }
        buttonEq.setOnClickListener {
            if (operation.isNotEmpty()) {
                result = doOperation(operation)
                if (result.equals(null)){
                    result = "Error"
                    text.text = result
                }else{
                    text.text = result.toString()
                }
                operation = ""
            }
        }

    }

   override fun onResume(){
        super.onResume()
        Log.d("Debug","onResume")
        val text: TextView = findViewById(R.id.textViewNumbers)
        text.text = result.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save the user's current game state.
        outState?.run {
            putString("contador", result)
        }
        // Always call the superclass so it can save the view hierarchy.
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Always call the superclass so it can restore the view hierarchy.
        super.onRestoreInstanceState(savedInstanceState)
        // Restore state members from saved instance.
        savedInstanceState?.run {
            result = savedInstanceState.getString("contador").toString()
        }
    }

}