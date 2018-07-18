package com.example.android.mytourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {

    FoodAdapter(Context context, ArrayList<Food> foods){
        super(context,0,foods);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.place_card, parent,false);
        }

        Food food = getItem(position);

        TextView name = convertView.findViewById(R.id.place_name);
        TextView location = convertView.findViewById(R.id.place_address);
        ImageView img = convertView.findViewById(R.id.place_image);

        name.setText(food.getName());
        location.setText(food.getLocation());
        img.setImageResource(food.getImgId());

        return convertView;
    }
}
