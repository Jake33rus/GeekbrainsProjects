package com.example.jake.calcul;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bPlus, bMinus, bDel, bMnoj, bRav, author;
    TextView otv;
    EditText chisA,chisB;
    String znak = "";
    int a, b, res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setOpenActBtnBehavior();
        setClickPlusBtn();
        setClickMinusBtn();
        setClickMnojBtn();
        setClickDelBtn();
        setClickRavBtn();


    }
    private void initViews() {
        bPlus=(Button)findViewById(R.id.button2);
        bMinus=(Button)findViewById(R.id.button4);
        author=(Button)findViewById(R.id.button6);
        bMnoj=(Button)findViewById(R.id.button);
        bDel=(Button)findViewById(R.id.button3);
        bRav=(Button)findViewById(R.id.button5);
        chisA=(EditText) findViewById(R.id.editText2);
        chisB=(EditText) findViewById(R.id.editText);
        otv=(TextView)findViewById(R.id.textView2);
    }
    private void setClickPlusBtn(){
        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            znak="Plus";
            }
        });}
        private void setClickMinusBtn(){
        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                znak="Minus";
            }
        });}
    private void setClickMnojBtn(){
        bMnoj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            znak="Mnoj";
            }
        });}
    private void setClickDelBtn(){
        bDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            znak="Del";
            }
        });}
    private void setClickRavBtn(){
        bRav.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                a=Integer.parseInt(chisA.getText().toString());
                b=Integer.parseInt(chisB.getText().toString());

            switch (znak){
                case "Plus":
                    res = a+b;
                    otv.setText(""+res);
                    break;
                case "Minus":
                    res=a-b;
                    otv.setText(""+res);
                    break;
                case "Mnoj":
                    res=a*b;
                    otv.setText(""+res);
                    break;
                case "Del":
                    res=a/b;
                    otv.setText(""+res);
                    break;
                default:
                    break;
            }
            }
        });}
    private void setOpenActBtnBehavior(){
        author.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.openActivity(MainActivity.this);
            }
        });

    }
    }

