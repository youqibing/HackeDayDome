package com.example.dell.hackedaydome.Module.Module_hot;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dell.hackedaydome.R;
import com.example.dell.hackedaydome.View.ListView.XListView;

/**
 * Created by dell on 2016/10/29.
 */

public class HotFragment extends Fragment{
    private ListView listView;
    private HotAdapter hotAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new,container,false);
        listView = (ListView) view.findViewById(R.id.list);
        hotAdapter = new HotAdapter(getActivity());

        listView.setAdapter(hotAdapter);

        return view;
    }
}
