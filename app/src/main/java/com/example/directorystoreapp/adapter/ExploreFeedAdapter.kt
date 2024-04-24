package com.example.directorystoreapp.adapter

import android.R.attr.radius
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Transformation
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.directorystoreapp.R
import com.squareup.picasso.Picasso


class ExploreFeedAdapter(private val context: Context, private val images: List<String>) :
    RecyclerView.Adapter<ExploreFeedAdapter.ExploreFeedHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreFeedHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.explore_feed_post, parent, false)
        return ExploreFeedHolder(view)
    }

    override fun onBindViewHolder(holder: ExploreFeedHolder, position: Int) {
        Glide.with(context)
            .load(images[position])
            .apply(RequestOptions.bitmapTransform(RoundedCorners(90)))
            .into(holder.postImage)

    }

    override fun getItemCount(): Int = images.size

    inner class ExploreFeedHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var headingText: TextView = itemView.findViewById(R.id.heading_text)
//        var professionText: TextView = itemView.findViewById(R.id.profession_text)
        var postImage: ImageView = itemView.findViewById(R.id.post_image)
//        var date: TextView = itemView.findViewById(R.id.post_date)
    }
}