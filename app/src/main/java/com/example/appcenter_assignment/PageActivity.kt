package com.example.appcenter_assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appcenter_assignment.databinding.ActivityPageBinding

class PageActivity: AppCompatActivity() {
    lateinit var binding:ActivityPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val value = intent.getStringExtra("exit")
        binding.endMessage.text = value
    }
}