package com.gs.praktikum5giansonia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter{
    //Global
    private Context mContext;
    ArrayList<Binatang>allData;

    public ImageAdapter(Context c, ArrayList<Binatang> Object){
        this.mContext=c;
        this.allData=Object;
    }

    @Override
    public int getCount() {
        return allData.size();
    }

    public Object getItem(int position){
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageview;
        View v=convertView;
        if(v==null){
            imageview = new ImageView(mContext);
            int h = mContext.getResources().getDisplayMetrics().densityDpi;
            imageview.setLayoutParams(new ViewGroup.LayoutParams(h-45,h-45));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(1,1,1,1);
        }else{
            imageview = (ImageView) convertView;
        }
        imageview.setImageResource(allData.get(position).gambar);
        return imageview;
    }
}
