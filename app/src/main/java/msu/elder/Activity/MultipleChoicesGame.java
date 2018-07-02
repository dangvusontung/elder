package msu.elder.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import msu.elder.R;

public class MultipleChoicesGame extends AppCompatActivity {
    ImageView imgMCQuestion;
    Button btnA, btnB, btnC, btnD;
    int score;
    int lives = 5;

    int  id_location, id_answer, id_a, id_b, id_c, id_d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choices_game);
        addControls();
        addEvents();

        if (lives == 0){
            gameOver();
        }
    }

    private void gameOver() {
        Toast.makeText(this,"Game Over"+"\n"+"Your score is " + score , Toast.LENGTH_SHORT).show();
    }

    private void addControls() {
        imgMCQuestion = findViewById(R.id.imgMCQuestion);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);



    }

    private void addEvents() {
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_answer = id_a;
                checkAnswer();
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_answer = id_b;
                checkAnswer();
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_answer = id_c;
                checkAnswer();
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_answer = id_d;
                checkAnswer();

            }
        });
    }

    private void checkAnswer() {
        if (id_answer == id_location){
            CorrectAnswer();
        }
        else {
            WrongAnswer();
        }
    }

    private void CorrectAnswer() {
        score += 1;
        lives -= 0;
    }

    private void WrongAnswer() {
        score += 0;
        lives -= 1;
    }




}
