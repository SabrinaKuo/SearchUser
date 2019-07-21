package com.example.sabrina.searchuser.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.sabrina.searchuser.R
import com.example.sabrina.searchuser.model.User

class SearchResultAdapter(private val resultList: List<User>) : RecyclerView.Adapter<SearchResultAdapter.SearchResultViewHodler>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SearchResultViewHodler {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.search_result_item, p0, false)
        return SearchResultViewHodler(v)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(viewHolder: SearchResultViewHodler, position: Int) {
        viewHolder.name?.text = resultList[position].login
        val imageUrl = resultList[position].avatar_url
        Glide.with(viewHolder.avatar.context).load(imageUrl).into(viewHolder.avatar)
    }

    inner class SearchResultViewHodler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name)
        val avatar = itemView.findViewById<ImageView>(R.id.avatar)

    }
}