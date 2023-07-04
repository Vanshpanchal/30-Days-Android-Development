package com.example.day30

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    var totalTime = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<ImageView>(R.id.start)
        val btnPause = findViewById<ImageView>(R.id.pause)
        val btnRestart = findViewById<ImageView>(R.id.restart)
        val seekbar = findViewById<SeekBar>(R.id.seekBar)

        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        totalTime = mediaPlayer.duration
        btnStart.setOnClickListener {
            mediaPlayer.start()

        }

        btnRestart.setOnClickListener {
            mediaPlayer.seekTo(0)
            mediaPlayer.start()
            seekbar.progress = 0

        }

        btnPause.setOnClickListener {
            mediaPlayer.pause()

        }

        seekbar.max = totalTime

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        val handler = Handler()
        handler.postDelayed(object : Runnable{
            override fun run() {
                seekbar.progress = mediaPlayer.currentPosition
                handler.postDelayed(this,1000)
            }

        }, 0)
    }
}