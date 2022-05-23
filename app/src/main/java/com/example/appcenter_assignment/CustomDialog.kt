package com.example.appcenter_assignment

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import com.example.appcenter_assignment.databinding.DialogBinding

class CustomDialog(color:String) {
    val color_string = color
    lateinit var binding: DialogBinding
    fun show(context: Context){
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = DialogBinding.inflate(inflater)
        //val customLayout = inflater.inflate(R.layout.dialog, null)
        val build = AlertDialog.Builder(context).apply {
            setView(binding.root)
        }

        val dialog = build.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.textView.text = color_string

        binding.okBtn.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}