package com.example.android.mytourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_food,container,false);

        int[] imgArray = {R.drawable.good_luck_cafe,R.drawable.burger_king,R.drawable.sujata_mastani,R.drawable.kayani_bakery,
                R.drawable.garden_vada_pav,R.drawable.marz_o_rin,R.drawable.vaishali,R.drawable.tiranga_non_veg,
                R.drawable.shabree,R.drawable.vohuman,R.drawable.coffee_house,R.drawable.om_jai_shanker,
                R.drawable.germany_bakery,R.drawable.chaitanya,R.drawable.bedekar_misal};

        ArrayList<Food> foods = new ArrayList<>();
        try{

            JSONObject obj = new JSONObject(loadJson());
            JSONArray arr = obj.getJSONArray("foods");

            for(int i=0 ;i<arr.length();i++){

                JSONObject jsonObject = arr.getJSONObject(i);

                String name = jsonObject.getString("name");
                String info = jsonObject.getString("info");
                String location = jsonObject.getString("location");
                String website = jsonObject.getString("website");

                foods.add(new Food(name,location,website,imgArray[i],info));
            }

        }catch(Exception e){}

        final FoodAdapter adapter = new FoodAdapter(getActivity(),foods);

        ListView listView = rootView.findViewById(R.id.food_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Food currentFood = adapter.getItem(position);

                Intent intent = new Intent(getActivity(),PlaceDetailActivity.class);
                intent.putExtra("placeObj", currentFood);
                startActivity(intent);

            }
        });

        return rootView;
    }

    @Nullable
    private String loadJson(){
        String json = null;

        try{
            InputStream is = getActivity().getAssets().open("pune_foods.json");
            int size = is.available();
            byte buffer[] = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");

        }catch (IOException e){
            return null;
        }

        return json;
    }

}
