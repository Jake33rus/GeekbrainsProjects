package com.example.jake.beutystyle.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jake.beutystyle.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView nailIv;
    private TextView nailTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nailIv = (ImageView) findViewById(R.id.im_nail);
        nailTv = (TextView) findViewById(R.id.tv_nail);
        nailIv.setOnClickListener(this);
        nailTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(nailTv) || view.equals(nailIv)) {
            Intent intent = new Intent(this, NailCategoryActivity.class);
            startActivity(intent);
        }
    }

    }
