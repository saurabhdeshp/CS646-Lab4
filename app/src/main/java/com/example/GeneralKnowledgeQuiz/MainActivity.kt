package com.example.GeneralKnowledgeQuiz
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.pizzapartyapp.R
import com.example.pizzapartyapp.R.id
import com.example.pizzapartyapp.R.layout


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStartQuiz = findViewById<Button>(R.id.button_start_quiz)
        buttonStartQuiz.setOnClickListener {
            navigateToQuizActivity()
        }

        val buttonCameraActivity = findViewById<Button>(R.id.button_camera_activity)
        buttonCameraActivity.setOnClickListener {
            navigateToCameraActivity()
        }

        val buttonSoundActivity = findViewById<Button>(R.id.button_sound_activity)
        buttonSoundActivity.setOnClickListener {
            navigateToSoundActivity()
        }

        val buttonLocationActivity = findViewById<Button>(R.id.button_location_activity)
        buttonLocationActivity.setOnClickListener {
            navigateToLocationActivity()
        }

        val buttonAnimationActivity = findViewById<Button>(R.id.button_animation_activity)
        buttonAnimationActivity.setOnClickListener {
            navigateToAnimationActivity()
        }
    }

    private fun navigateToQuizActivity() {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToCameraActivity() {
        val intent = Intent(this, CameraActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSoundActivity() {
        val intent = Intent(this, SoundActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToLocationActivity() {
        val intent = Intent(this, LocationActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToAnimationActivity() {
        val intent = Intent(this, AnimationActivity::class.java)
        startActivity(intent)
    }

    private fun showExampleFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ExampleFragment())
            .commit()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                val settingsIntent = Intent(this, SettingsActivity::class.java)
                startActivity(settingsIntent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}