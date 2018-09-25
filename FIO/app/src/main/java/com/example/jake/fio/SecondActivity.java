package com.example.jake.fio;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public final static int ACTIVITY_OPEN_REQUEST_CODE = 1234;
    public final static String TEXT_FROM_PREV_ACTIVITY_KEY = "text_from_prev_act_key";

    TextView textView;
    EditText textInputFio, textInputDate, textInputSex;
    Button openActivityBtn;

    public static void openActivity(Activity activity) {
        Intent intent = new Intent(activity, SecondActivity.class);
        activity.startActivity(intent);
    }

    public static void openActivity(Activity activity, String text) {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtra(TEXT_FROM_PREV_ACTIVITY_KEY, text);
        activity.startActivity(intent);
    }

    public static void openActivityForResult(Activity activity, String text) {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtra(TEXT_FROM_PREV_ACTIVITY_KEY, text);
        activity.startActivityForResult(intent, ACTIVITY_OPEN_REQUEST_CODE);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initViews();
        setTextFromPreviousActivity();
        setOpenActBtnBehavior();
    }

    private void initViews() {
        textView = (TextView)findViewById(R.id.text);
        textInputFio = (EditText)findViewById(R.id.textFio);
        textInputDate = (EditText)findViewById(R.id.textDate);
        textInputSex = (EditText)findViewById(R.id.textSex);
        openActivityBtn = (Button)findViewById(R.id.send_btn);
    }

    private void setTextFromPreviousActivity() {
        String text = getIntent().getStringExtra(TEXT_FROM_PREV_ACTIVITY_KEY);
        textView.setText(text);
    }

    private void setOpenActBtnBehavior() {
        openActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textFio = textInputFio.getText().toString();
                String textDate = textInputDate.getText().toString();
                String textSex = textInputSex.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(TEXT_FROM_PREV_ACTIVITY_KEY, textFio + " \n " + textDate + " \n " + textSex);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }
}
