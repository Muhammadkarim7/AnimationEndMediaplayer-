package com.example.mediaplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.mediaplayer.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.music)

        val anim = AnimationUtils.loadAnimation(this, R.anim.item_anim)

        var array = ArrayList<String>()
        array.add("Ofarin")
        array.add("Balli")
        array.add("Tashakkur")
        array.add("A'lo")
        array.add("Barakalla")
        array.add("Yaxshi")
        array.add("Qoyil")
        array.add("Zo'r")
        array.add("Gap yo'q")

        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                if (!isPlaying) {
                    mediaPlayer.start()
                    isPlaying = true
                }
            }

            override fun onAnimationEnd(animation: Animation?) {
                if (isPlaying) {
                    mediaPlayer.pause()
                    mediaPlayer.seekTo(0) // Musiqa boshiga qaytarish
                    isPlaying = false
                }
            }

            override fun onAnimationRepeat(animation: Animation?) {
                // Animatsiya qayta boshlandi
            }
        })

        binding.btnNext.setOnClickListener {
            binding.text.startAnimation(anim)
            var son = Random.nextInt(9)
            when (son) {
                0 -> binding.text.text = "Ofarin"
                1 -> binding.text.text = "Balli"
                2 -> binding.text.text = "Tashakkur"
                3 -> binding.text.text = "A'lo"
                4 -> binding.text.text = "Barakalla"
                5 -> binding.text.text = "Yaxshi"
                6 -> binding.text.text = "Qoyil"
                7 -> binding.text.text = "Zo'r"
                8 -> binding.text.text = "Gap yo'q"
            }
        }
    }
}