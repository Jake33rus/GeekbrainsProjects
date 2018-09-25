package com.example.jake.viktorina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b_true;
    Button b_false;
    Button next;
    TextView question;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setInspectionBtnTrue();
        setInspectionBtnFalse();
        answer.setVisibility(View.INVISIBLE);
        clickedNext();
    }
    private void initViews() {
        b_false=(Button)findViewById(R.id.button2);
        b_true=(Button)findViewById(R.id.button);
        question=(TextView)findViewById(R.id.textView2);
        answer=(TextView)findViewById(R.id.textView3);
        next=(Button)findViewById(R.id.button3);
    }
   private void setInspectionBtnTrue(){
       b_true.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (question.getText().equals("Верно ли что, в среднем курица откладывает 190 яиц в год?")){
                   answer.setText(R.string.res_true);
                   answer.setVisibility(View.VISIBLE);
               }
               if (question.getText().equals("Верно ли что, у золотой рыбки память 3 секунды?")){
                   answer.setText(R.string.res_true);
                   answer.setVisibility(View.VISIBLE);
               }
               if (question.getText().equals("Верно ли что, верблюд может обходиться без воды дольше, чем жираф?")){
                   answer.setText(R.string.res_false);
                   answer.setVisibility(View.VISIBLE);
               }
               if (question.getText().equals("Верно ли что, Дельфины спят с закрытыми глазами?")){
                   answer.setText(R.string.res_false);
                   answer.setVisibility(View.VISIBLE);
               }
               if (question.getText().equals("Верно ли что, Самки тли рождаются беременными?")){
                   answer.setText(R.string.res_true);
                   answer.setVisibility(View.VISIBLE);
               }
           }
       });}
   private void setInspectionBtnFalse() {
        b_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (question.getText().equals("Верно ли что, в среднем курица откладывает 190 яиц в год?")){
                answer.setText(R.string.res_false);
                answer.setVisibility(View.VISIBLE);
                }
                if (question.getText().equals("Верно ли что, у золотой рыбки память 3 секунды?")){
                    answer.setText(R.string.res_false);
                    answer.setVisibility(View.VISIBLE);
                }
                if (question.getText().equals("Верно ли что, верблюд может обходиться без воды дольше, чем жираф?")){
                    answer.setText(R.string.res_true);
                    answer.setVisibility(View.VISIBLE);
                }
                if (question.getText().equals("Верно ли что, Дельфины спят с закрытыми глазами?")){
                    answer.setText(R.string.res_true);
                    answer.setVisibility(View.VISIBLE);
                }
                if (question.getText().equals("Верно ли что, Самки тли рождаются беременными?")){
                    answer.setText(R.string.res_false);
                    answer.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    private void clickedNext(){
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setVisibility(View.INVISIBLE);
                if (question.getText().equals("Верно ли что, в среднем курица откладывает 190 яиц в год?")){
                        question.setText(R.string.question2);
                    return;
                }
                if (question.getText().equals("Верно ли что, у золотой рыбки память 3 секунды?")){
                    question.setText(R.string.question3);
                    return;
                }
                if (question.getText().equals("Верно ли что, верблюд может обходиться без воды дольше, чем жираф?")){
                    question.setText(R.string.question4);
                    return;
                }
                if (question.getText().equals("Верно ли что, Дельфины спят с закрытыми глазами?")){
                    question.setText(R.string.question5);
                    return;
                }
                if (question.getText().equals("Верно ли что, Самки тли рождаются беременными?")){
                    question.setVisibility(View.INVISIBLE);
                    answer.setText(R.string.final_v);
                    answer.setVisibility(View.VISIBLE);
                }
            }
        });

    }
   }

