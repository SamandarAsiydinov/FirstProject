package com.samsdk.firstproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*

class MainActivity : AppCompatActivity() {

    private val languages = arrayOf("Java","Python","Kotlin","Scala","C++","")
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // accessing the TextSwitcher from XML layout
        val textSwitcher = findViewById<TextSwitcher>(R.id.textSwitch)
        textSwitcher.setFactory {
            val textView = TextView(this@MainActivity)
            textView.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            textView.textSize = 32f
            textView.setTextColor(Color.BLUE)
            textView
        }
        textSwitcher.setText(languages[index])

        // previous button functionality
        val prev = findViewById<Button>(R.id.btnPrev)
        prev.setOnClickListener {
            index = if (index - 1 >= 0) index - 1 else languages.size
            textSwitcher.setText(languages[index])
        }
        val button = findViewById<Button>(R.id.btnNext)
        button.setOnClickListener {
            index = if (index + 1 < languages.size) index + 1 else 0
            textSwitcher.setText(languages[index])
        }
    }
}