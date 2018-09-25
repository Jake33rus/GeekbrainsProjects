package com.example.jake.shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.id.edit;

public class MainActivity extends AppCompatActivity {
    Button add, check, del;
    EditText znach, key;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setClickAddBtn();
        setClickCheckBtn();
        setClickDelBtn();

    }
    private void initViews(){
        add=(Button)findViewById(R.id.buttonAdd);
        del=(Button)findViewById(R.id.buttonDel);
        check=(Button)findViewById(R.id.buttonCheck);
        znach=(EditText)findViewById(R.id.editTextZnach);
        key=(EditText)findViewById(R.id.editTextKey);
        this.sharedPreferences = getApplicationContext().getSharedPreferences("AUTH_PREFERENCE", Context.MODE_PRIVATE);
    }
    private void setClickAddBtn(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(key.getText().toString(), znach.getText().toString());
                editor.apply();
            }
        });
    }
    private void setClickCheckBtn(){
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPreferences.contains(key.getText().toString())) {
                znach.setText(sharedPreferences.getString(key.getText().toString(),""));
                }
            }

        });
    }
    private void setClickDelBtn(){
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(key.getText().toString());
                editor.apply();
            }
        });
    }
}
