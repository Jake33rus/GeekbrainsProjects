package com.example.jake.calcul;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public static void openActivity(Activity activity) {
        Intent intent = new Intent(activity, SecondActivity.class);
        activity.startActivity(intent);}
}
