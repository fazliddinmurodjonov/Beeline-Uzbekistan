package com.example.androidhardviewlesson7.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhardviewlesson7.databinding.ItemTariffBinding
import com.example.androidhardviewlesson7.models.Tariff

class TariffAdapter(var tariffList: ArrayList<Tariff>) :
    RecyclerView.Adapter<TariffAdapter.MyViewHolder>() {
    lateinit var adapterListener: OnMyItemClickListener

    interface OnMyItemClickListener {
        fun onClick(tariff: Tariff, position: Int)
    }

    fun setOnMyItemClickListener(listener: OnMyItemClickListener) {
        adapterListener = listener
    }
    inner class MyViewHolder(var binding: ItemTariffBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(tariff: Tariff, position: Int) {
            binding.root.setOnClickListener {
                adapterListener.onClick(tariff, position)
            }
            binding.tariffImage.setImageResource(tariff.tariffImage!!)
            binding.tariffName.text = tariff.tariffName.toString()
            binding.tariffMoney.text = tariff.tariffPayment.toString()
            binding.tariffOutCall.text = tariff.tariffOutCall.toString()
            binding.tariffInternet.text = tariff.tariffInternet.toString()
            binding.tariffSms.text = tariff.tariffSMS.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemTariffBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tariff = tariffList[position]
        holder.onBind(tariff, position)
    }

    override fun getItemCount(): Int = tariffList.size


}