package com.example.androidhardviewlesson7.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhardviewlesson7.databinding.ItemServicesBinding
import com.example.androidhardviewlesson7.models.News
import com.example.androidhardviewlesson7.models.Services

class ServicesAdapter(var servicesList: ArrayList<Services>) :
    RecyclerView.Adapter<ServicesAdapter.MyViewHolder>() {
    lateinit var adapterListener: OnMyItemClickListener

    interface OnMyItemClickListener {
        fun onClick(services: Services)
    }

    fun setOnMyItemClickListener(listener: OnMyItemClickListener) {
        adapterListener = listener
    }

    inner class MyViewHolder(val binding: ItemServicesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(services: Services) {
            binding.root.setOnClickListener {
                adapterListener.onClick(services)
            }
            binding.servicesImage.setImageResource(services.serviceImage!!)
            binding.servicesCostDay.text = services.servicePriceDay
            binding.servicesCostMonth.text = services.servicePriceMonth
            binding.servicesName.text = services.serviceName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemServicesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val services = servicesList[position]
        holder.onBind(services)
    }

    override fun getItemCount(): Int = servicesList.size
}