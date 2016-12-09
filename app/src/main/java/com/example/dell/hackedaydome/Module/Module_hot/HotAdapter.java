package com.example.dell.hackedaydome.Module.Module_hot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.hackedaydome.Module.Module_new.NewAdapter;
import com.example.dell.hackedaydome.R;

/**
 * Created by dell on 2016/10/30.
 */

public class HotAdapter extends BaseAdapter{
    private Context context;
    private LayoutInflater inflater;

    public HotAdapter(Context context){
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

        ItemHolder itemViewHolder = null;
        if(convertView == null){
            itemViewHolder = new ItemHolder();
            convertView = inflater.inflate(R.layout.hot_itemview,parent,false);

            itemViewHolder.movie_name = (TextView)convertView.findViewById(R.id.movie_name);
            itemViewHolder.favorite_img = (ImageView)convertView.findViewById(R.id.favorite_img);
            itemViewHolder.favorite_num = (TextView)convertView.findViewById(R.id.favorite_num);
            itemViewHolder.comment_img = (ImageView)convertView.findViewById(R.id.comment_img);
            itemViewHolder.comment_num = (TextView)convertView.findViewById(R.id.comment_num);

            convertView.setTag(itemViewHolder);
        }else {
            itemViewHolder = (ItemHolder)convertView.getTag();
        }

        return convertView;
    }

    static class ItemHolder {

        public TextView movie_name;

        public ImageView favorite_img;
        public ImageView comment_img;
        public TextView favorite_num;
        public TextView comment_num;
    }
}
