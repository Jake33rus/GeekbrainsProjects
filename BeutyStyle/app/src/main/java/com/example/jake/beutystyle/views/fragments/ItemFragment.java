package com.example.jake.beutystyle.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.jake.beutystyle.model.Nail;
import com.example.jake.beutystyle.R;
/**
 * Created by Jake on 23.02.2017.
 */

public class ItemFragment extends Fragment {
    TextView titleTextView, descriptionTextView;
    ImageView imageView;

    int itemIndex = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(android.R.layout.fragment_layout, container, false);

        initViews(view);
        setTexts();
        setImage();

        return view;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    private void initViews(View view) {
        titleTextView = (TextView)view.findViewById(R.id.title_text);
        descriptionTextView = (TextView)view.findViewById(R.id.description_text);
        imageView = (ImageView)view.findViewById(R.id.item_image);
    }

    private void setTexts() {
        titleTextView.setText(Nail.nails[itemIndex].getName());
        descriptionTextView.setText(Nail.nails[itemIndex].getDescription());
    }

    private void setImage() {
        imageView.setImageResource(Nail.nails[itemIndex].getImageResourceId());
    }
}
