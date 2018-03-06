package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * global variable that keeps track of the score
     * right answers
     * RadioGroups for the resetScore method
     */
    int score = 0;
    RadioButton question1;
    RadioButton question2;
    RadioButton question5;
    CheckBox question3_cb1;
    CheckBox question3_cb2;
    CheckBox question3_cb3;
    CheckBox question3_cb4;
    CheckBox question6_cb1;
    CheckBox question6_cb2;
    CheckBox question6_cb3;
    CheckBox question6_cb4;
    EditText question4;
    EditText question7;

    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = findViewById(R.id.question_rg1);
        radioGroup2 = findViewById(R.id.question_rg2);
        radioGroup3 = findViewById(R.id.question_rg3);
        question1 = findViewById(R.id.question_rg1_rb3);
        question2 = findViewById(R.id.question_rg2_rb2);
        question5 = findViewById(R.id.question_rg3_rb1);
/**
 * Get access to all checkboxes. We have to get the status of each one to correctly compute the correct answer
 */
        question3_cb1 = findViewById(R.id.question3_cb1);
        question3_cb2 = findViewById(R.id.question3_cb2);
        question3_cb3 = findViewById(R.id.question3_cb3);
        question3_cb4 = findViewById(R.id.question3_cb4);
        question4 = findViewById(R.id.question_EdTxt1);
        question6_cb1 = findViewById(R.id.question6_cb1);
        question6_cb2 = findViewById(R.id.question6_cb2);
        question6_cb3 = findViewById(R.id.question6_cb3);
        question6_cb4 = findViewById(R.id.question6_cb4);
        question7 = findViewById(R.id.question_EdTxt2);
    }

    /**
     * This method  triggers when the reset button is pressed*
     */

    public void resetAnswers() {

        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        radioGroup3.clearCheck();
        question3_cb1.setChecked(false);
        question3_cb2.setChecked(false);
        question3_cb3.setChecked(false);
        question3_cb4.setChecked(false);
        question4.setText("");
        question6_cb1.setChecked(false);
        question6_cb2.setChecked(false);
        question6_cb3.setChecked(false);
        question6_cb4.setChecked(false);
        question7.setText("");

    }

    /**
     * calculates the score based on the right answers
     **/

    public int calculateScore(int score) {


        boolean firstQuestion = question1.isChecked();
        if (firstQuestion) {
            score += 1;
        }

        boolean secondQuestion = question2.isChecked();
        if (secondQuestion) {
            score += 1;
        }

        if ((question3_cb2.isChecked() && question3_cb3.isChecked()) && !(question3_cb1.isChecked() || question3_cb4.isChecked())) {
            score += 1;
        }

        String fourthQuestion = question4.getText().toString();
        if (fourthQuestion.equals("Australia"))
            score += 1;
        else if (fourthQuestion.equals("australia") || fourthQuestion.equals("AUSTRALIA"))
            score += 1;

        boolean fiveQuestion = question5.isChecked();
        if (fiveQuestion) {
            score += 1;
        }

        if ((question6_cb1.isChecked() && question6_cb2.isChecked()) && !(question6_cb3.isChecked() || question6_cb4.isChecked())) {
            score += 1;
        }

        String sevenQuestion = question7.getText().toString();

        if (sevenQuestion.equals("Italy")) {
            score += 1;
        } else if (sevenQuestion.equals("italy") || sevenQuestion.equals("ITALY"))
            score += 1;

        return (score);
    }

    /**
     * it triggers when the Submit Answers button is pressed and it shows a Toast message with a score summary, based on the right answers given
     **/

    public void DisplayResults(View view) {
        int finalScore = calculateScore(score);
        String finalScoreMessage = "You answered " + finalScore + " questions out of 7.";
        Toast.makeText(this, finalScoreMessage, Toast.LENGTH_LONG).show();
        resetAnswers();
    }
}
