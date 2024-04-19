package com.example.directorystoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.directorystoreapp.adapter.ImageSliderAdapter
import com.example.directorystoreapp.adapter.VideoAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val viewPager = view?.findViewById<ViewPager2>(R.id.viewPager)
        val recRecyclerview = view?.findViewById<RecyclerView>(R.id.rec_recyclerview)
        val videoRecyclerview = view?.findViewById<RecyclerView>(R.id.video_recyclerview)


        val imageSliderAdapter = activity?.applicationContext?.let { ImageSliderAdapter(it, getImages()) }
        viewPager?.adapter = imageSliderAdapter

        val data = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5") // Sample data
        val adapter = activity?.applicationContext?.let { VideoAdapter(it, data) }

        val layoutManager = LinearLayoutManager(requireContext().applicationContext)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        videoRecyclerview?.layoutManager = layoutManager
        videoRecyclerview?.adapter = adapter

        return view
    }

    private fun getImages(): List<String> {
        // Provide URLs of online shopping site images
        return listOf(
            "https://fastly.picsum.photos/id/12/2500/1667.jpg?hmac=Pe3284luVre9ZqNzv1jMFpLihFI6lwq7TPgMSsNXw2w",
            "https://fastly.picsum.photos/id/13/2500/1667.jpg?hmac=SoX9UoHhN8HyklRA4A3vcCWJMVtiBXUg0W4ljWTor7s",
            "https://fastly.picsum.photos/id/14/2500/1667.jpg?hmac=ssQyTcZRRumHXVbQAVlXTx-MGBxm6NHWD3SryQ48G-o"
            // Add more URLs as needed
        )
    }

}