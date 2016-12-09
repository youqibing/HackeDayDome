package com.example.dell.hackedaydome.Module.Module_new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dell.hackedaydome.Adapter.LazyListAdapter;
import com.example.dell.hackedaydome.R;


/**
 * Created by dell on 2016/10/29.
 */

public class NewAdapter extends LazyListAdapter<NewMovies> {

    private LayoutInflater layoutInflater;
    private ListView listView;
    private Context context;

    public NewAdapter(Context context){
        this.context = context;

        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public long getItemId(int position) {
        return 5;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemViewHolder itemViewHolder = null;
        if(convertView == null){
            itemViewHolder = new ItemViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_layout,parent,false);

            itemViewHolder.movie_name = (TextView)convertView.findViewById(R.id.movie_name);
            itemViewHolder.favorite_img = (ImageView)convertView.findViewById(R.id.favorite_img);
            itemViewHolder.favorite_num = (TextView)convertView.findViewById(R.id.favorite_num);
            itemViewHolder.comment_img = (ImageView)convertView.findViewById(R.id.comment_img);
            itemViewHolder.comment_num = (TextView)convertView.findViewById(R.id.comment_num);

            convertView.setTag(itemViewHolder);
        }else {
            itemViewHolder = (ItemViewHolder)convertView.getTag();
        }

        return convertView;
    }

    static class ItemViewHolder {

        public TextView movie_name;

        public ImageView favorite_img;
        public ImageView comment_img;
        public TextView favorite_num;
        public TextView comment_num;
    }
}
