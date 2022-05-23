package com.example.appcenter_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.appcenter_assignment.databinding.RecycleviewItemBinding

class Adapter(private val data:ArrayList<Nation>):RecyclerView.Adapter<Adapter.ViewHolder>() {
    var colorArray = arrayListOf<String>("Red","Orange","Yellow","Green","Blue","Indigo","Purple")
    inner class ViewHolder(private val binding:RecycleviewItemBinding):RecyclerView.ViewHolder(binding.root){
        val name: TextView = binding.tvName
        val capital: TextView = binding.tvCapital
        val layout: ConstraintLayout = binding.background
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecycleviewItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
        //return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycleview_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = data[position].name
        holder.capital.text = data[position].capital
        //색 지정하기
        when(position%7){
            0 -> holder.layout.setBackgroundResource(R.color.red)
            1 -> holder.layout.setBackgroundResource(R.color.orange)
            2 -> holder.layout.setBackgroundResource(R.color.yellow)
            3 -> holder.layout.setBackgroundResource(R.color.green)
            4 -> holder.layout.setBackgroundResource(R.color.blue)
            5 -> holder.layout.setBackgroundResource(R.color.indigo)
            6 -> holder.layout.setBackgroundResource(R.color.purple)
        }
        holder.itemView.setOnClickListener {
            CustomDialog(colorArray[position%7]).show(it.context)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}