package com.example.kotlinviewtodo.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.kotlinviewtodo.databinding.FragmentAddItemDialogBinding

class AddItemDialog : DialogFragment() {
    interface DialogResultListener { //Communicating b/t Activity and Fragment using an interface.
        fun fireResult(string: String)
    }

    lateinit var result : DialogResultListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        result = activity as DialogResultListener //Cast the activity as implemented interface
    }

    private var _binding : FragmentAddItemDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddItemDialogBinding.inflate(inflater, container, false)

        binding.cancelButton.setOnClickListener {
            dialog?.cancel()
        }

        binding.addButton.setOnClickListener {
            result.fireResult(binding.newTask.text.toString())
            dialog?.cancel()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}