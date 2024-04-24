package com.example.directorystoreapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.directorystoreapp.R

class RecentlyAddedAdapter(private val context: Context, private val images: List<String>) :
    RecyclerView.Adapter<RecentlyAddedAdapter.RecentlyAddedHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentlyAddedHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recently_added_user_item, parent, false)
        return RecentlyAddedHolder(view)
    }

    override fun onBindViewHolder(holder: RecentlyAddedHolder, position: Int) {
        Glide.with(context)
            .load(images[position])
            .circleCrop()
            .into(holder.profilePhoto)
    }

    override fun getItemCount(): Int = images.size

    inner class RecentlyAddedHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profilePhoto: ImageView = itemView.findViewById(R.id.recently_added_photo)
    }
}