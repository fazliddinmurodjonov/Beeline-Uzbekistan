package com.example.androidhardviewlesson7.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhardviewlesson7.databinding.ItemSmsBinding
import com.example.androidhardviewlesson7.models.SMS

class SMSAdapter(var smsList: ArrayList<SMS>) : RecyclerView.Adapter<SMSAdapter.MyViewHolder>() {

    lateinit var adapterListener: OnMyItemClickListener

    fun setOnMyItemClickListener(listener: OnMyItemClickListener) {
        adapterListener = listener
    }

    interface OnMyItemClickListener {
        fun onClick(sms: SMS)
    }

    inner class MyViewHolder(var binding: ItemSmsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(sms: SMS) {
            binding.root.setOnClickListener {
                adapterListener.onClick(sms)
            }
            binding.smsName.text = sms.smsName
            binding.smsMoney.text = sms.smsPayment.toString()
            binding.smsQuantity.text = sms.smsCount.toString()
            binding.smsImage.setImageResource(sms.smsImage!!)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemSmsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val sms = smsList[position]
        holder.onBind(sms)
    }

    override fun getItemCount(): Int = smsList.size


}