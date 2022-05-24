package com.example.recycler_view33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recycler_view33.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var adapter = MemeAdapter()
    private val imageIdList = listOf<Int>(R.drawable.pepega1, R.drawable.pepega2, R.drawable.pepega3, R.drawable.pepega4)
    private var currIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                if (currIndex >= imageIdList.size) currIndex = 0
                val currMem = Mem(imageIdList[currIndex], "mem")
                adapter.addMem(currMem)
                currIndex++
            }
        }
    }
}