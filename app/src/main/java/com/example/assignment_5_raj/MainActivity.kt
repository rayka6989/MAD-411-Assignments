package com.example.assignment_5_raj

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private  lateinit var  nameTextView : TextView
    private lateinit var  enterEditText: EditText
    private  lateinit var  showNameButton: Button
    private  lateinit var  displayNameTextView: TextView
    private  lateinit var  view : View

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enterEditText = findViewById(R.id.enter_name_edit_text)
        showNameButton = findViewById(R.id.show_name_button)
        displayNameTextView = findViewById(R.id.display_name_text_view)

        showNameButton.setOnClickListener {
            val outputName = enterEditText.text.toString()
            displayNameTextView.text = "Hello, $outputName"
        }
    }
}