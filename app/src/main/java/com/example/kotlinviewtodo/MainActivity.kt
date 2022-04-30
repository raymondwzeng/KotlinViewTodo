package com.example.kotlinviewtodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinviewtodo.databinding.ActivityMainBinding
import com.example.kotlinviewtodo.fragments.AddItemDialog

class MainActivity : AppCompatActivity(), AddItemDialog.DialogResultListener {
    private lateinit var _binding : ActivityMainBinding //Note: It seems like according to Google, only Fragments live after View is nuked. So no need to null this out?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root

        _binding.floatingActionButton.setOnClickListener {
            val dialog = AddItemDialog()
            dialog.show(supportFragmentManager, null)
        }

        setContentView(view)
    }

    override fun fireResult(string: String) {
        println("Result: $string")
    }
}