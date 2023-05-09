package com.example.GeneralKnowledgeQuiz


import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.pizzapartyapp.R

class AnimationActivity : AppCompatActivity() {

    private lateinit var frameAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        val imageViewFrameAnimation = findViewById<ImageView>(R.id.image_view_frame_animation)
        // Remove this line
        // imageViewFrameAnimation.setBackgroundResource(R.drawable.frame_by_frame_animation)
        frameAnimation = imageViewFrameAnimation.background as AnimationDrawable
    }

    override fun onStart() {
        super.onStart()
        frameAnimation.start()
    }

    override fun onStop() {
        super.onStop()
        frameAnimation.stop()
    }
}
