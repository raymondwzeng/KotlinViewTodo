package com.example.kotlinviewtodo.fragments

import androidx.lifecycle.ViewModel

class ListModel {
    var todoList : MutableList<String> = mutableListOf("Foo", "Bar", "Baz")
}

class ListViewModel : ViewModel() {
    val List = ListModel().todoList
}