package com.example.androidhardviewlesson7.adapters

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhardviewlesson7.databinding.ItemNewsBinding
import com.example.androidhardviewlesson7.models.News

class NewsAdapter(var newsList: ArrayList<News>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
lateinit var adapterListener:OnMyItemClickListener
    interface OnMyItemClickListener{
        fun onClick(news: News)
    }
    fun setOnMyItemClickListener(listener:OnMyItemClickListener)
    {
        adapterListener=listener
    }

    inner class MyViewHolder(var binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(news: News) {
            binding.root.setOnClickListener {
                adapterListener.onClick(news)
            }
            binding.newsImage.setImageResource(news.newsImage!!)
            binding.newsDate.text = news.newsDate
            binding.newsName.text = news.newsName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val news = newsList[position]
        holder.onBind(news)
    }

    override fun getItemCount(): Int = newsList.size
}