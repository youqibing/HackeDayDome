package com.example.dell.hackedaydome.Module.Module_Mine;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by dell on 2016/10/29.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private static final int TAB_COUNT = 2;
    private String[] Tabtitle = {"截图","评论"};

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CutFragment cutFragment = new CutFragment();
                return cutFragment;
            case 1:
                CommentFragment commentFragment = new CommentFragment();
                return commentFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Tabtitle[position];
    }
}
