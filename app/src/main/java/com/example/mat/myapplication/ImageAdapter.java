package com.example.mat.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.mat.myapplication.R;

public class ImageAdapter extends BaseAdapter {

    public ImageAdapter(Context ctx){
        myContext = ctx;
    }

    private Context myContext;

    private Integer[] imgId = {
            R.drawable.hdhexo,
            R.drawable.ball,
            R.drawable.eye,
            R.drawable.hexodos,
            R.drawable.magic,
            R.drawable.hexoq,
            R.drawable.reptile,
            //R.drawable.joker,
            //R.drawable.lagarto,
            //R.drawable.skeleton,
            //R.drawable.wap,
            //R.drawable.prettyass
    };

    @Override
    public int getCount() {
        return imgId.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(myContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(imgId[position]);
        return imageView;
    }

}

