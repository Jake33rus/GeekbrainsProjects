package com.example.jake.beutystyle.views.activities;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.jake.beutystyle.R;
import com.example.jake.beutystyle.model.Nail;
import com.example.jake.beutystyle.views.adapters.RecyclerAdapter;
/**
 * Created by Jake on 23.02.2017.
 */

public class NailCategoryActivity extends AppCompatActivity {
    RecyclerView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setList();
    }

    private void initViews() {
        listView = (RecyclerView)findViewById(R.id.list);
    }

    private void setList() {
        RecyclerAdapter adapter = new RecyclerAdapter(Nail.nails, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);

        listView.setLayoutManager(manager);
        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        int fragmentCount = getSupportFragmentManager().getBackStackEntryCount();
        if(fragmentCount > 0) {
            getSupportFragmentManager().popBackStack();
        }
        super.onBackPressed();
    }

}
