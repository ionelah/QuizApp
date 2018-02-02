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
    CheckBox question3;
    EditText question4;

    RadioGroup radioGroup1;
    RadioGroup radioGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method  triggers when the reset button is pressed*
     */

    public void resetAnswers(View view) {

        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        question3.setChecked(false);
        question4.setText("");

    }

    /**
     * calculates the score based on the right answers
     **/

    public int calculateScore(int score) {


        boolean firstQuestion =
                question1.isChecked();
        if (firstQuestion) score += 1;


        boolean secondQuestion =
                question2.isChecked();
        if (secondQuestion) {
            score += 1;
        }

        boolean thirdQuestion =
                jSunAnswer.isChecked();
        if (thirdQuestion) {
            score += 1;
        }
        boolean fourthQuestion =
                jupiterAnswer.isChecked();
        if (fourthQuestion) {
            score += 1;
        }
        boolean fifthQuestion =
                milkyWayAnswer.isChecked();
        if (fifthQuestion) {
            score += 1;
        }
        boolean sixthQuestion =
                noMoonsAnswer.isChecked();
        if (sixthQuestion) {
            score += 1;
        }
        boolean seventhQuestion =
                giantStormAnswer.isChecked();
        if (seventhQuestion) {
            score += 1;
        }
        boolean eightQuestion1 =
                tiltedOrbit.isChecked();

        boolean eightQuestion2 =
                ringsSurrounded.isChecked();
        if (eightQuestion1 && eightQuestion2) {
            score += 1;

        }
        boolean ninthQuestion1 =
                alphaCentauri.isChecked();
        boolean ninthQuestion2 =
                redDwarf.isChecked();
        if (ninthQuestion1 && ninthQuestion2) {
            score += 1;
        }

        String tenthQuestion = plutoAnswer.getText().toString();
        if (tenthQuestion.contains("Pluto") || tenthQuestion.contains("Plutone"))
            score += 1;

        return (score);

    }

    /**
     * it triggers when the Submit Answers button is pressed and it shows a Toast message with a score summary, based on the right answers given
     **/

    public void submitAnswer(View view) {
        String name = nameField.getText().toString();
        int finalScore = calculateScore(score);
        String finalScoreMessage = name + " you answered " + finalScore + " questions out of 10.";


        if (finalScore >= 8) {
            Toast.makeText(this, finalScoreMessage + "\n" +
                    "Great! You know our Solar System very well!", Toast.LENGTH_LONG).show();
        }

        if (finalScore == 7) {
            Toast.makeText(this, finalScoreMessage + "\n" + "You're on the right way! Keep following the stars...",
                    Toast.LENGTH_LONG).show();
        }

        if (finalScore == 6) {
            Toast.makeText(this, finalScoreMessage + "\n" + "You're on the right way! Keep following the stars...",
                    Toast.LENGTH_LONG).show();
        }

        if (finalScore == 5) {
            Toast.makeText(this, finalScoreMessage + "\n" + "You're on the right way! Keep following the stars...",
                    Toast.LENGTH_LONG).show();
        }

        if (finalScore < 5) {
            Toast.makeText(this, finalScoreMessage + "\n" + "Hmmm... It seems you need to learn more about..." + "\n" + "Try again",
                    Toast.LENGTH_LONG).show();
        }

        Intent sendIntent = new Intent(this, Main2Activity.class);
        String message = "I scored " + finalScore + " in the Solar System Quiz App. Join me and Try!";
        sendIntent.putExtra("message", message);
        startActivity(sendIntent);

    }


    public void DisplayResults(View view) {
    }
}
