package com.example.pizzapartyapp
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
import com.example.pizzapartyapp.R.id
import com.example.pizzapartyapp.R.layout


class MainActivity : AppCompatActivity() {



    /**
     * The radio button - answers
     */
    private lateinit var radioGroup1: RadioGroup
    private lateinit var radioGroup2: RadioGroup
    private lateinit var radioGroup3: RadioGroup
    private lateinit var radioGroup4: RadioGroup
    private lateinit var radioGroup5: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        showExampleFragment()


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


    private fun resetQuiz() {
        radioGroup1.clearCheck()
        radioGroup2.clearCheck()
        radioGroup3.clearCheck()
        radioGroup4.clearCheck()
        radioGroup5.clearCheck()
    }

    fun calculateClick(view: View) {
        var score = 0;


        radioGroup1 = findViewById(R.id.q1_radio_group)
        radioGroup2 = findViewById(R.id.q2_radio_group)
        radioGroup3 = findViewById(R.id.q3_radio_group)
        radioGroup4 = findViewById(R.id.q4_radio_group)
        radioGroup5 = findViewById(R.id.q5_radio_group)


        val answer1 = when (radioGroup1.checkedRadioButtonId) {
            id.q1_opt_1 -> "1930"
            id.q1_opt_2 -> "1945"
            else -> "1960"
        }

        val answer2 = when (radioGroup2.checkedRadioButtonId) {
            id.q2_opt_1 -> "13"
            id.q2_opt_2 -> "12"
            else -> "14"
        }

        val answer3 = when (radioGroup3.checkedRadioButtonId) {
            id.q3_opt_1 -> "Rome"
            id.q3_opt_2 -> "Los Angeles"
            else -> "Palestine"
        }

        val answer4 = when (radioGroup4.checkedRadioButtonId) {
            id.q4_opt_1 -> "Plato"
            id.q4_opt_2 -> "Socrates"
            else -> "Copernicus"
        }

        val answer5 = when (radioGroup5.checkedRadioButtonId) {
            id.q5_opt_1 -> "Brazil"
            id.q5_opt_2 -> "France"
            else -> "Portugal"
        }

        if (answer1 == "1945" ) {

            score += 1;
        }
        if (answer2 == "12" ) {
            score += 1;
        }
        if (answer3 == "Rome" ) {
            score += 1;
        }
        if (answer4 == "Copernicus" ) {
            score += 1;
        }
        if (answer5 == "Brazil" ) {
            score += 1;
        }


        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Quiz Results")
        alertDialogBuilder.setMessage("Your score is: $score")
        alertDialogBuilder.setPositiveButton("OK") { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }
        alertDialogBuilder.setNegativeButton("Reset Quiz") { _: DialogInterface, _: Int ->
            resetQuiz()
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()

    }

}