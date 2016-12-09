package com.example.dell.hackedaydome.Module.Module_Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.dell.hackedaydome.R;

/**
 * Created by dell on 2016/10/29.
 */

public class MoviesDetailAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;

    public MoviesDetailAdapter(Context context){
        this.context = context;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 5;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MovieItemViewHolder movieItemViewHolder = null;

        if (convertView == null) {
            movieItemViewHolder = new MovieItemViewHolder();
            convertView = inflater.inflate(R.layout.movie_itemview, parent, false);

            movieItemViewHolder.movie_image = (ImageView)convertView.findViewById(R.id.movie_images);
            convertView.setTag(movieItemViewHolder);
        }else {
            movieItemViewHolder = (MovieItemViewHolder)convertView.getTag();
        }

        return convertView;
    }
        static class MovieItemViewHolder{
            public ImageView movie_image;
        }

}
