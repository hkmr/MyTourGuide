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

public class PlaceAdapter extends ArrayAdapter<Place> {

    PlaceAdapter(Context context, ArrayList<Place> obj){
        super(context,0,obj);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.place_card,parent,false);

        Place currentPlace = getItem(position);

        TextView placeName = (TextView) convertView.findViewById(R.id.place_name);
        TextView placeAddress = (TextView) convertView.findViewById(R.id.place_address);
        ImageView placeImage = (ImageView) convertView.findViewById(R.id.place_image);

        placeName.setText(currentPlace.getmName());
        placeAddress.setText(currentPlace.getmLocation());
        placeImage.setImageResource(currentPlace.getmImageId());

        return convertView;
    }
}
