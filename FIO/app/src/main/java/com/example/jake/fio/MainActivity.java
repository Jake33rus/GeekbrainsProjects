package com.example.jake.fio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inputText;
    TextView textView;
    Button openActivityBtn, openUrlBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setOpenActBtnBehavior();
    }

    private void initViews() {
        inputText = (EditText)findViewById(R.id.text_input);
        textView = (TextView)findViewById(R.id.text_from_second_activity);
        openActivityBtn = (Button)findViewById(R.id.open_activity_button);
    }

    private void setOpenActBtnBehavior() {
        openActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.openActivityForResult(MainActivity.this,
                        inputText.getText().toString());
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SecondActivity.ACTIVITY_OPEN_REQUEST_CODE && resultCode == RESULT_OK) {
            textView.setText(data.getStringExtra(SecondActivity.TEXT_FROM_PREV_ACTIVITY_KEY));
        }
    }

    private void toastShow() {
        Toast toast = Toast.makeText(getApplicationContext(),"Ошибка запуска браузера!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
