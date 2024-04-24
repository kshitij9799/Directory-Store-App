package com.example.directorystoreapp

import android.os.Bundle
import android.support.annotation.UiThread
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.directorystoreapp.adapter.ImageSliderAdapter
import com.example.directorystoreapp.adapter.RecentlyAddedAdapter
import com.example.directorystoreapp.adapter.VideoAdapter
import java.util.Timer
import java.util.TimerTask

class HomeFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var timer: Timer
    private val DELAY_MS: Long = 10000 // Delay in milliseconds before the auto-scroll starts
    private val PERIOD_MS: Long = 10000

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        viewPager = view?.findViewById<ViewPager2>(R.id.viewPager)!!
        val recRecyclerview = view.findViewById<RecyclerView>(R.id.rec_recyclerview)
        val videoRecyclerview = view.findViewById<RecyclerView>(R.id.video_recyclerview)


        val imageSliderAdapter = activity?.applicationContext?.let { ImageSliderAdapter(it, getImages()) }
        viewPager.adapter = imageSliderAdapter

        //Scrolling related code
        startAutoScroll()
        viewPager.setPageTransformer(MyPageTransformer())

        val data = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5") // Sample data
        val videoAdapter = activity?.applicationContext?.let { VideoAdapter(it, getThumbnail()) }

        var layoutManager = LinearLayoutManager(requireContext().applicationContext)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        videoRecyclerview?.layoutManager = layoutManager
        videoRecyclerview?.adapter = videoAdapter

        val recentlyAddedAdapter = activity?.applicationContext?.let { RecentlyAddedAdapter(it,getProfileImages()) }
        layoutManager = LinearLayoutManager(requireContext().applicationContext)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recRecyclerview?.layoutManager = layoutManager
        recRecyclerview?.adapter = recentlyAddedAdapter

        return view
    }

    private fun startAutoScroll() {
        timer = Timer()
        timer.schedule(object : TimerTask() {
            @UiThread
            override fun run() {
                    // Increment ViewPager2 current item
                    val currentItem = viewPager.currentItem
                    val nextItem = if (currentItem == viewPager.adapter?.itemCount?.minus(1)) 0 else currentItem + 1
                    viewPager.currentItem = nextItem
            }
        }, DELAY_MS, PERIOD_MS)
    }

    private fun getImages(): List<String> {
        return listOf(
            "https://fastly.picsum.photos/id/12/2500/1667.jpg?hmac=Pe3284luVre9ZqNzv1jMFpLihFI6lwq7TPgMSsNXw2w",
            "https://fastly.picsum.photos/id/13/2500/1667.jpg?hmac=SoX9UoHhN8HyklRA4A3vcCWJMVtiBXUg0W4ljWTor7s",
            "https://fastly.picsum.photos/id/14/2500/1667.jpg?hmac=ssQyTcZRRumHXVbQAVlXTx-MGBxm6NHWD3SryQ48G-o"
        )
    }

    private fun getProfileImages(): List<String> {
        return listOf(
            "https://images.pexels.com/photos/1043471/pexels-photo-1043471.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/697509/pexels-photo-697509.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1040880/pexels-photo-1040880.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1559486/pexels-photo-1559486.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1310474/pexels-photo-1310474.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/2379004/pexels-photo-2379004.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1898555/pexels-photo-1898555.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1130626/pexels-photo-1130626.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1043471/pexels-photo-1043471.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/697509/pexels-photo-697509.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1040880/pexels-photo-1040880.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1559486/pexels-photo-1559486.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1310474/pexels-photo-1310474.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/2379004/pexels-photo-2379004.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1898555/pexels-photo-1898555.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1130626/pexels-photo-1130626.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        )
    }

    private fun getThumbnail(): List<String> {
        return listOf(
            "https://assets.visme.co/templates/banners/thumbnails/i_National-Park-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Luxury-Dining-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Acoustic-Session-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Running-Tips-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Healthy-Lunch-Ideas-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_National-Park-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Luxury-Dining-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Acoustic-Session-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Running-Tips-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Healthy-Lunch-Ideas-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_National-Park-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Luxury-Dining-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Acoustic-Session-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Running-Tips-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Healthy-Lunch-Ideas-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_National-Park-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Luxury-Dining-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Acoustic-Session-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Running-Tips-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Healthy-Lunch-Ideas-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_National-Park-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Luxury-Dining-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Acoustic-Session-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Running-Tips-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Healthy-Lunch-Ideas-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_National-Park-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Luxury-Dining-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Acoustic-Session-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Running-Tips-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Healthy-Lunch-Ideas-Youtube-Video-Cover_full.jpg",
            "https://assets.visme.co/templates/banners/thumbnails/i_Entrepreneur-Guide-Youtube-Video-Cover_full.jpg"
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    inner class MyPageTransformer : ViewPager2.PageTransformer {
        override fun transformPage(page: android.view.View, position: Float) {
            val absPosition = Math.abs(position)
            page.apply {
                scaleX = 0.75f + (1 - absPosition) * 0.25f
                scaleY = 0.75f + (1 - absPosition) * 0.25f
            }
        }
    }


}