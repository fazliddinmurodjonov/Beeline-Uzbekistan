package com.example.androidhardviewlesson7.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhardviewlesson7.databinding.ItemMinutesBinding
import com.example.androidhardviewlesson7.models.Minutes

class MinutesAdapter(var minutesList: ArrayList<Minutes>) :
    RecyclerView.Adapter<MinutesAdapter.MyViewHolder>() {
    lateinit var adapterListener: OnMyItemClickListener

    interface OnMyItemClickListener {
        fun onClick(minutes: Minutes)
    }

    fun setOnMyItemClickListener(listener: OnMyItemClickListener) {
        adapterListener = listener
    }

    inner class MyViewHolder(var binding: ItemMinutesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(minutes: Minutes) {
            binding.root.setOnClickListener {
                adapterListener.onClick(minutes)
            }
            binding.minutesName.text = minutes.minutesName
            binding.minutesImage.setImageResource(minutes.minutesImage!!)
            binding.minutesInternet.text = minutes.minutesInternet.toString()
            binding.minutesMinute.text = minutes.minutesMinute.toString()
            binding.minutesMoney.text = minutes.minutesPayment.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemMinutesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val minutes = minutesList[position]
        holder.onBind(minutes)
    }

    override fun getItemCount(): Int = minutesList.size
}