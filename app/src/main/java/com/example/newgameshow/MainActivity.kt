package com.example.newgameshow

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private lateinit var player: MediaPlayer

    class MyAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        private val resources = listOf(
            R.drawable.newgame3, R.drawable.b9ffc64af1ebec33282bc0f7,
            R.drawable.sdgf87947843, R.drawable.bebec33282bc0f7,
            R.drawable.aga435, R.drawable.agfh45,
            R.drawable.sdfhs, R.drawable.joasidg,
            R.drawable.isfh, R.drawable.syasho,
            R.drawable.jhkl, R.drawable.mo7t
        )

        override fun getCount(): Int{
            return resources.size
        }

        override fun getItem(position: Int): Fragment {
            return ImageFragment.newInstance(resources[position])
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pager.adapter = MyAdapter(supportFragmentManager)
        val handler = Handler()
        timer(period = 5000) {
            handler.post{
                pager.currentItem = (pager.currentItem + 1) % 10
            }
        }
        player = MediaPlayer.create(this, R.raw.comicalpizzicato)
        player.isLooping = true
    }

    override fun onResume(){
        super.onResume()
        player.start()
    }

    override fun onPause(){
        super.onPause()
        player.pause()
    }
}
