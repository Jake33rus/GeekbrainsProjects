package com.example.jake.beutystyle.views.activities;

/**
 * Created by Jake on 23.02.2017.
 */

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jake.beutystyle.model.Nail;
import com.example.jake.beutystyle.R;
import com.example.jake.beutystyle.views.fragments.ItemFragment;

/**
 * Created by Jake on 19.02.2017.
 */

public class NailActivity extends AppCompatActivity {
    private static final String INDEX_KEY = "index_key";

    public static void openActivity(int itemIndex, Activity activity) {
        Intent intent = new Intent(activity, NailActivity.class);
        intent.putExtra(INDEX_KEY, itemIndex);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nail);

        int index = getIntent().getIntExtra(INDEX_KEY, 0);
        setFragment(index);
    }

    private void setFragment(int index) {
        ItemFragment fragment = new ItemFragment();
        fragment.setItemIndex(index);

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack("item");
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}

