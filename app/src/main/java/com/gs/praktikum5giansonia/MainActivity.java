package com.gs.praktikum5giansonia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Global
    ArrayList allData=new ArrayList();
    MediaPlayer media ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Memasukan gambar dan suara binatang
        allData.add(new Binatang("Anjing",R.drawable.anjing,R.raw.anjing));
        allData.add(new Binatang("Bebek",R.drawable.bebek,R.raw.bebek));
        allData.add(new Binatang("Burung",R.drawable.burung,R.raw.burung));
        allData.add(new Binatang("Gajah",R.drawable.gajah,R.raw.gajah));
        allData.add(new Binatang("Harimau",R.drawable.harimau,R.raw.harimau));
        allData.add(new Binatang("Kambing",R.drawable.kambing,R.raw.kambing));
        allData.add(new Binatang("Kucing",R.drawable.kucing,R.raw.kucing));
        allData.add(new Binatang("Kuda",R.drawable.kuda,R.raw.kuda));
        allData.add(new Binatang("Monyet",R.drawable.monyet,R.raw.monyet));
        allData.add(new Binatang("Sapi",R.drawable.sapi,R.raw.sapi));

        ListView listView =(ListView) findViewById(R.id.ListView);
        BIanatangAdapter adapter = new BIanatangAdapter(this,R.layout.item_row_list,allData);
        listView.setAdapter(adapter);
    }

    public void pindahKeGrid(View v){
        Intent i=new Intent(MainActivity.this,GridViewActivity.class);
        startActivity(i);
        media.stop();
        finish();
    }
}