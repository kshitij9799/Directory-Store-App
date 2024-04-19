package com.example.directorystoreapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.directorystoreapp.R
import com.squareup.picasso.Picasso

class VideoAdapter(private val context: Context, private val images: List<String>) :
RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.video_slider, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.tex.text = images[position]
    }

    override fun getItemCount(): Int = images.size

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tex: TextView = itemView.findViewById(R.id.tex)
    }
}