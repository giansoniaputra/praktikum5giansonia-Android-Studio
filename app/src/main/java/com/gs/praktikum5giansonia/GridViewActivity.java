package com.gs.praktikum5giansonia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridViewActivity extends Activity implements AdapterView.OnItemClickListener{

    //Global
    GridView gridview;
    MediaPlayer media;
    ArrayList<Binatang> allData=new ArrayList<Binatang>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

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
        gridview=(GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this,allData));
        gridview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Binatang binatang=allData.get(position);
        Toast.makeText(getBaseContext(),"Nama Binatang: "+binatang.jenis, Toast.LENGTH_SHORT).show();

        //Cek jika suara ada yang dimaikan atau media tidak kosong
        if(media!=null&&media.isPlaying()){
            media.stop();
            media.release();
        }

        media = MediaPlayer.create(getBaseContext(),binatang.suara);
        media.setLooping(false);
        media.start();
    }

    public void pindahKeGrid2(View v){

        Intent i=new Intent(GridViewActivity.this,MainActivity.class);
        startActivity(i);
        if(media!=null&&media.isPlaying()){
            media.stop();
            media.release();
        }
        finish();
    }


}