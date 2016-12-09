package com.example.dell.hackedaydome.Adapter;

import android.widget.BaseAdapter;

import de.greenrobot.dao.query.LazyList;

/**
 * Created by dell on 2016/10/29.
 */

public abstract class LazyListAdapter<T> extends BaseAdapter {
    LazyList<T> lazyList = null;
    public LazyListAdapter() {

    }

    public LazyListAdapter(LazyList<T> initialList) {
        lazyList = initialList;
    }

    public void replaceLazyList(LazyList<T> newList) {
        if(lazyList != null) {
            lazyList.close();
        }

        lazyList = newList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return lazyList == null ? 0 : lazyList.size();
    }

    @Override
    public T getItem(int i) {
        return lazyList == null ? null : lazyList.get(i);
    }

    public void close() {
        if(lazyList != null) {
            lazyList.close();
            lazyList = null;
        }
    }
}

