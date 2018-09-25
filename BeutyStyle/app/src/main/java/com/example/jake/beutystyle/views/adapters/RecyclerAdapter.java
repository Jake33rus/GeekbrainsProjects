package com.example.jake.beutystyle.views.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jake.beutystyle.model.Nail;
import com.example.jake.beutystyle.views.fragments.ItemFragment;
/**
 * Created by Jake on 23.02.2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListHolder> {
    private Activity activity;
    private Nail[] nails;

    public RecyclerAdapter(Nail[] nails, Activity activity) {
        this.nails = nails;
        this.activity = activity;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);

        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListHolder holder, final int position) {
        holder.textView.setText(nails[position].toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              com.example.jake.beutystyle.views.activities.NailActivity.openActivity(holder.getAdapterPosition(), activity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nails == null ? 0 : nails.length;
    }

    class ListHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ListHolder(View itemView) {
            super(itemView);
            initViews(itemView);
        }

        private void initViews(View itemView) {
            textView = (TextView)itemView.findViewById(android.R.id.text1);
        }
    }
}
