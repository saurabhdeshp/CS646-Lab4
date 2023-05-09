package com.example.GeneralKnowledgeQuiz


import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pizzapartyapp.R
import java.lang.ref.WeakReference
import java.util.concurrent.TimeUnit

class SoundActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var buttonPlaySound: Button
    private lateinit var textViewTimestamp: TextView
    private lateinit var seekBarPlayback: SeekBar
    private val updateHandler = UpdateHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound)

        textViewTimestamp = findViewById(R.id.text_view_timestamp)
        buttonPlaySound = findViewById(R.id.button_play_sound)
        seekBarPlayback = findViewById(R.id.seek_bar_playback)

        mediaPlayer = MediaPlayer.create(this, R.raw.sound)
        seekBarPlayback.max = mediaPlayer.duration

        buttonPlaySound.setOnClickListener {
            playSound()
        }

        seekBarPlayback.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                    updateTimestamp(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
        updateHandler.removeCallbacksAndMessages(null)
    }

    private fun playSound() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            buttonPlaySound.text = "Play Sound"
        } else {
            mediaPlayer.start()
            buttonPlaySound.text = "Pause Sound"
            updateSeekBar()
        }

        mediaPlayer.setOnCompletionListener {
            buttonPlaySound.text = "Play Sound"
            seekBarPlayback.progress = 0
            updateTimestamp(0)
        }
    }

    private fun updateSeekBar() {
        seekBarPlayback.progress = mediaPlayer.currentPosition
        updateTimestamp(mediaPlayer.currentPosition)
        updateHandler.sendEmptyMessageDelayed(0, 100)
    }

    private fun updateTimestamp(progress: Int) {
        val minutes = TimeUnit.MILLISECONDS.toMinutes(progress.toLong())
        val seconds = TimeUnit.MILLISECONDS.toSeconds(progress.toLong()) - TimeUnit.MINUTES.toSeconds(minutes)
        textViewTimestamp.text = String.format("%02d:%02d", minutes, seconds)
    }

    private class UpdateHandler(soundActivity: SoundActivity) : Handler() {
        private val activityWeakReference: WeakReference<SoundActivity> = WeakReference(soundActivity)

        override fun handleMessage(msg: Message) {
            val activity = activityWeakReference.get()
            activity?.apply {
                updateSeekBar()
            }
        }
    }
}