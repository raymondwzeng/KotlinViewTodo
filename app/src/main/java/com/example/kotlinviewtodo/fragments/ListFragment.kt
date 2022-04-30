package com.example.kotlinviewtodo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinviewtodo.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding : FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment.
        _binding = FragmentListBinding.inflate(inflater, container, false)
        //Tie the viewmodel to the fragment, though we may end up actually wanting the owner to be the activity.
        val model = ViewModelProvider(this)[(ListViewModel::class.java)]
        val view = binding.root
        binding.recyclerView.adapter = ListAdapter(model.List)
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}