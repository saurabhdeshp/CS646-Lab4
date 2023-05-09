package com.example.GeneralKnowledgeQuiz
import android.content.DialogInterface
import android.os.Bundle

import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.pizzapartyapp.R


class QuizActivity : AppCompatActivity(){
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
        setContentView(R.layout.activity_quiz)

        // Add the rest of the quiz-related code here
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
            R.id.q1_opt_1 -> "1930"
            R.id.q1_opt_2 -> "1945"
            else -> "1960"
        }

        val answer2 = when (radioGroup2.checkedRadioButtonId) {
            R.id.q2_opt_1 -> "13"
            R.id.q2_opt_2 -> "12"
            else -> "14"
        }

        val answer3 = when (radioGroup3.checkedRadioButtonId) {
            R.id.q3_opt_1 -> "Rome"
            R.id.q3_opt_2 -> "Los Angeles"
            else -> "Palestine"
        }

        val answer4 = when (radioGroup4.checkedRadioButtonId) {
            R.id.q4_opt_1 -> "Plato"
            R.id.q4_opt_2 -> "Socrates"
            else -> "Copernicus"
        }

        val answer5 = when (radioGroup5.checkedRadioButtonId) {
            R.id.q5_opt_1 -> "Brazil"
            R.id.q5_opt_2 -> "France"
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