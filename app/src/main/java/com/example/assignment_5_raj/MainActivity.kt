package com.example.assignment_5_raj

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val expenseName = findViewById<EditText>(R.id.E1)
        val amount = findViewById<EditText>(R.id.E2)
        val date = findViewById<EditText>(R.id.E3)
        val expenceButton = findViewById<Button>(R.id.B1)
        val expenceList = findViewById<ListView>(R.id.L1)
        val removeBtn = findViewById<Button>(R.id.R1)

        val listOfExpence = mutableListOf<String>()
        val expenceAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfExpence)
        expenceList.adapter = expenceAdapter


        expenceButton.setOnClickListener {
            val expName = expenseName.text.toString()
            val expAmount = amount.text.toString()
            val purchaseDate = date.text.toString()
            if (expName.isEmpty() || expAmount.isEmpty()) {
                Toast.makeText(this, "ENTER NAME AND AMOUNT ", Toast.LENGTH_SHORT).show()
            } else {
                val expence = "$expName - $expAmount - $purchaseDate"

                listOfExpence.add(expence)

                expenceAdapter.notifyDataSetChanged()


                expenseName.text.clear()
                amount.text.clear()
                date.text.clear()
                Toast.makeText(this, "EXPENCE HAS BEEN ADDED ", Toast.LENGTH_SHORT).show()
            }
        }

        expenseName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        removeBtn.setOnClickListener {
            if (listOfExpence.isNotEmpty()) {
                listOfExpence.removeAt(listOfExpence.size - 1)
                expenceAdapter.notifyDataSetChanged() // UPDATE THE LIST VIEW
                Toast.makeText(this, "THE LAST EXPENCE HAS BEEN REMOVED!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "NOTHING REMOVED!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}