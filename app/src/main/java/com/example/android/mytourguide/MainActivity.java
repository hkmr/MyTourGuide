package com.example.android.mytourguide;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Place> places = new ArrayList<>();

        try{
            JSONObject obj = new JSONObject(loadJson());
            JSONArray arr = obj.getJSONArray("places");

            ArrayList<Integer> images = new ArrayList<>();
            images.add(R.drawable.shaniwar_wada_palace);
            images.add(R.drawable.aga_khan_palace);
            images.add(R.drawable.vetal_tekdi);
            images.add(R.drawable.parvati_hill_temple);
            images.add(R.drawable.pashan_lake);
            images.add(R.drawable.shinde_chhatri);
            images.add(R.drawable.peacock_bay);
            images.add(R.drawable.lal_mahal);


            for(int i =0; i<arr.length();i++){
                JSONObject currentObj = arr.getJSONObject(i);

                String name = currentObj.getString("name");

                JSONObject locationObj = currentObj.getJSONObject("location");
                String address = locationObj.getString("address");
                String locationUri = locationObj.getString("uri");

                String info = currentObj.getString("info");
                String hours = currentObj.getString("hours");
                String website = currentObj.getString("website");
                String phone = currentObj.getString("phone");

                places.add(new Place(name,address,info,images.get(i),locationUri,hours,website,phone));
            }


        }catch (Exception e){
        }


        final PlaceAdapter adapter = new PlaceAdapter(this,places);

        ListView listView = (ListView) findViewById(R.id.place_list);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Place currentPlace = adapter.getItem(position);

                String[] placeData = {
                  currentPlace.getmName(),
                  currentPlace.getmLocation(),
                  currentPlace.getmInfo(),
                        String.valueOf(currentPlace.getmImageId())
                };

                Intent intent = new Intent(MainActivity.this,PlaceDetailActivity.class);
                intent.putExtra("placeObj", currentPlace);
                startActivity(intent);

            }
        });


    }

    @Nullable
    private String loadJson(){
        String json = null;

        try{
            InputStream is = getAssets().open("pune_places.json");
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
