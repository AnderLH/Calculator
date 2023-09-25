package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.calculatorapp.Operations.doOperation

class MainActivity : AppCompatActivity() {
    private var operation:String? = "0"
    private var result:String? = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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
            text.text = operation.toString()
        }

        buttonN2.setOnClickListener {
            operation += "2"
            text.text = operation.toString()
        }

        buttonN3.setOnClickListener {
            operation += "3"
            text.text = operation.toString()
        }

        buttonN4.setOnClickListener {
            operation += "4"
            text.text = operation.toString()
        }

        buttonN5.setOnClickListener {
            operation += "5"
            text.text = operation.toString()
        }

        buttonN6.setOnClickListener {
            operation += "6"
            text.text = operation.toString()
        }

        buttonN7.setOnClickListener {
            operation += "7"
            text.text = operation.toString()
        }

        buttonN8.setOnClickListener {
            operation += "8"
            text.text = operation.toString()
        }

        buttonN9.setOnClickListener {
            operation += "9"
            text.text = operation.toString()
        }

        buttonN0.setOnClickListener {
            operation += "0"
            text.text = operation.toString()
        }

        buttonPls.setOnClickListener {
            operation = "$operation+"
            text.text = operation.toString()

        }
        buttonMin.setOnClickListener {
            operation = "$operation-"
            text.text = operation.toString()
        }
        buttonEq.setOnClickListener {
            result = operation.toString()
            result = doOperation(result!!)
            if (result.equals(null)){
                result = "Error"
                text.text = result
            }else{
                text.text = result.toString()
            }
            operation = ""
        }

    }

   override fun onResume(){
        super.onResume()
        val text: TextView = findViewById(R.id.textViewNumbers)
        text.text = operation.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save the user's current game state.
        outState?.run {
            putString("contador", operation)
        }
        // Always call the superclass so it can save the view hierarchy.
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Always call the superclass so it can restore the view hierarchy.
        super.onRestoreInstanceState(savedInstanceState)
        // Restore state members from saved instance.
        savedInstanceState?.run {
            operation = savedInstanceState.getString("contador").toString()
        }
    }

}