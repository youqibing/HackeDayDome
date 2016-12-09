package com.example.dell.hackedaydome.Adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dell.hackedaydome.Utils.CommonUtils;

/**
 * Created by dell on 2016/10/29.
 */

public class BaseLazyAdapter <T extends LazyListAdapter> extends BaseAdapter implements View.OnClickListener {
    private static final int ID_POS = CommonUtils.fakeGenId();

    private Context mContext;
    private T mAdapter;

    private OnCursorItemClickListener mListener;

    public BaseLazyAdapter(Context context, T adapter) {
        this.mContext = context;
        this.mAdapter = adapter;
    }

    @Override
    public int getCount() {
        return mAdapter.getCount();
    }

    @Override
    public Object getItem(int position) {
        return mAdapter.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return mAdapter.hasStableIds();
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        mAdapter.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mAdapter.unregisterDataSetObserver(observer);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return mAdapter.areAllItemsEnabled();
    }

    @Override
    public boolean isEnabled(int position) {
        return mAdapter.isEnabled(position);
    }

    @Override
    public int getItemViewType(int position) {
        return mAdapter.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return mAdapter.getViewTypeCount();
    }

    @Override
    public boolean isEmpty() {
        return mAdapter.isEmpty();
    }

    public T getWrappedAdapter() {
        return mAdapter;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View child = mAdapter.getView(position, convertView, parent);
        setOnItemClickListenerIfNeed(child, position);
        return child;
    }

    public void setOnItemClickListener(OnCursorItemClickListener mListener) {
        this.mListener = mListener;
    }

    private boolean setOnItemClickListenerIfNeed(View child, int pos) {
        if (mListener == null) {
            return false;
        }
        child.setOnClickListener(this);
        child.setTag(ID_POS, pos);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (mListener == null) {
            //no need to feedback
        }
        int pos = (Integer) v.getTag(ID_POS);

        mListener.onItemClick(v, pos);
    }

    public static interface OnCursorItemClickListener {
        void onItemClick(View view, int position);
    }
}
