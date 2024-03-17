package com.example.hackaton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.hackaton.databinding.ActivityBookWorkStationBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class BookWorkStation : AppCompatActivity(),CalenderAdapter.CalendarInterface {

    companion object{
        private val TAG ="MainActivity"
    }

    private lateinit var binding: ActivityBookWorkStationBinding
    private val sdf=SimpleDateFormat("MMMM yyyy", Locale.ENGLISH)
    private var mStartD: Date? =null

    private val calenderAdapter=CalenderAdapter(this, arrayListOf())
    private val calenderList= ArrayList<calenderData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBookWorkStationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initCalender()
    }

    private fun initCalender() {
        mStartD=Date()

    }

    override fun onSelect(calenderData: calenderData, position: Int, day: TextView) {
        TODO("Not yet implemented")
    }
}