package com.example.lab1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val result = findViewById<TextView>(R.id.text_result)
        val input: EditText = findViewById(R.id.main_input)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
            val text = input.text.toString()
            val inputChar = text[0]
            if (inputChar.isLetter() && !(inputChar.isLowerCase())) {
                if (text == "L" || text == "M" || text == "K" || text == "D") {
                    result.text = "Это согласная буква"
                }
                else result.text = "Возможно, это гласная буква"
            }
            else result.text = "Invalid sintax"
        }
    }
}