package com.zc.swipelayoutdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var userViewAdapter: UserViewAdapter
    private lateinit var partsViewAdapter: PartsViewAdapter
    private var userList: MutableList<String> = arrayListOf()
    private var partList: MutableList<Part> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userList.add("John Smith")
        userList.add("Sam Crow")
        userList.add("Jane Doe")

        partList.add(Part("Power Supply", 50f))
        partList.add(Part("CPU Cooler", 110f))
        partList.add(Part("GPU", 330f))
        partList.add(Part("Motherboard", 100f))

        userViewAdapter = UserViewAdapter(this, userList)
        partsViewAdapter = PartsViewAdapter(this, partList.toList())

        recycler_view.isNestedScrollingEnabled = true
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
        setAdapter()
    }

    private fun setAdapter() {
        recycler_view.adapter = partsViewAdapter
    }
}
