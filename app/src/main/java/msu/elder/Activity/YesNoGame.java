package msu.elder.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import msu.elder.R;

public class YesNoGame extends AppCompatActivity {

    TextView txtYNQuestion;
    ImageView imgQuestionYN;
    Button btnYes, btnNo;

    int id_question_location, id_img_location;
    int scores =0 , lives = 5 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes_no_game);
        addControls();
        addEvents();
    }

    private void addControls() {

        txtYNQuestion = findViewById(R.id.txtYNQuestion);
        imgQuestionYN = findViewById(R.id.imgQuestionYN);
        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);

    }

    private void addEvents() {
        if(id_question_location == id_img_location){
            btnYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CorrectAnswer();
                }
            });
            btnNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WrongAnswer();
                }
            });
        }

    }

    private void CorrectAnswer() {
        scores += 1;
        lives -= 0;
    }

    private void WrongAnswer() {
        scores += 0;
        lives -= 1;
    }


}
