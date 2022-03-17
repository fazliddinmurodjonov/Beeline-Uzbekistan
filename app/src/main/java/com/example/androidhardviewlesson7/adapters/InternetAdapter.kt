package com.example.androidhardviewlesson7.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhardviewlesson7.databinding.ItemInternetBinding
import com.example.androidhardviewlesson7.models.Internet

class InternetAdapter(var internetList: ArrayList<Internet>) :
    RecyclerView.Adapter<InternetAdapter.MyViewHolder>() {
    lateinit var adapterListener: OnMyItemClickListener

    interface OnMyItemClickListener {
        fun onClick(internet: Internet)
    }

    fun setOnMyItemClickListener(listener: OnMyItemClickListener) {
        adapterListener = listener
    }

    inner class MyViewHolder(var binding: ItemInternetBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun onBind(internet: Internet) {
            binding.root.setOnClickListener {
                adapterListener.onClick(internet)
            }
            binding.internetName.text = internet.internetName
            binding.internetCost.text = internet.internetPayment
            binding.internetImage.setImageResource(internet.internetImage!!)
            binding.internetGB1.text = internet.internetTraffic.toString()
            binding.internetGB2.text = internet.internetTraffic.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemInternetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val internet = internetList[position]
        holder.onBind(internet)
    }

    override fun getItemCount(): Int = internetList.size

}