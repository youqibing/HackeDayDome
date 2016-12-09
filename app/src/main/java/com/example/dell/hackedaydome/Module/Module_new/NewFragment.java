package com.example.dell.hackedaydome.Module.Module_new;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dell.hackedaydome.Adapter.BaseLazyAdapter;
import com.example.dell.hackedaydome.DBOpenHelper;
import com.example.dell.hackedaydome.HackeDayDomeApplication;
import com.example.dell.hackedaydome.Module.Module_Main.MoivesDetailActivity;
import com.example.dell.hackedaydome.Module.Module_serach.SerachActivity;
import com.example.dell.hackedaydome.R;
import com.example.dell.hackedaydome.View.ListView.XListView;

/**
 * Created by dell on 2016/10/29.
 */

public class NewFragment extends Fragment implements View.OnClickListener{

    private XListView listView;
    private NewAdapter newAdapter;
    private BaseLazyAdapter<NewAdapter> mCursorAdapter;
    private ImageView serach_img;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot,container,false);
        serach_img = (ImageView)view.findViewById(R.id.serach_img);
        listView = (XListView) view.findViewById(R.id.listView);

        serach_img.setOnClickListener(this);

        newAdapter = new NewAdapter(getActivity());
        mCursorAdapter = new BaseLazyAdapter<NewAdapter>(getActivity(), newAdapter);
        mCursorAdapter.setOnItemClickListener(new BaseLazyAdapter.OnCursorItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.e("test",position+"");
                Intent intent = new Intent(getActivity(), MoivesDetailActivity.class);
                startActivity(intent);
            }
        });

        listView.setAdapter(mCursorAdapter);
        listView.setPullRefreshEnable(false);
        listView.setPullLoadEnable(true);

        listView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
            }
            @Override
            public void onLoadMore() {
                loadData();
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.serach_img:
            startActivity(new Intent(getActivity(), SerachActivity.class));
            break;
        }
    }

    private void loadData() {
        //HackeDayDomeApplication.getInstance().getJobManager().addJobInBackground(new GoodsCommentJob(goodsId, mPage + 1));
    }
}
