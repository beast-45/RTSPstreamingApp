package com.example.rtspstreamingapp

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var player: ExoPlayer
    private lateinit var playerView: PlayerView
    private lateinit var btnPlayPause: MaterialButton
    private lateinit var btnFullscreen: ImageButton
    private lateinit var etRtspUrl: TextInputEditText

    private var isFullscreen = false
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playerView = findViewById(R.id.playerView)
        btnPlayPause = findViewById(R.id.btnPlayPause)
        btnFullscreen = findViewById(R.id.btnFullscreen)
        etRtspUrl = findViewById(R.id.etRtspUrl)


        player = ExoPlayer.Builder(this).build()
        playerView.player = player

        btnPlayPause.setOnClickListener {
            val url = etRtspUrl.text.toString().trim()
            if (url.isEmpty()) {
                Toast.makeText(this, "Enter a valid RTSP URL", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!isPlaying) {
                startStream(url)
            } else {
                pauseStream()
            }
        }

        btnFullscreen.setOnClickListener {
            toggleFullscreen()
        }
    }

    private fun startStream(url: String) {
        try {
            val mediaItem = MediaItem.fromUri(url)
            player.setMediaItem(mediaItem)
            player.prepare()
            player.play()

            btnPlayPause.text = "Pause"
            isPlaying = true
        } catch (e: Exception) {
            Toast.makeText(this, "Error starting stream: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun pauseStream() {
        player.pause()
        btnPlayPause.text = "Play"
        isPlaying = false
    }

    private fun toggleFullscreen() {
        if (isFullscreen) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        } else {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
        isFullscreen = !isFullscreen
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}
