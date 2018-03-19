package com.example.wtl.foursage20.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 滑动页面适配器
 * Created by WTL on 2018/3/11.
 */

public class Pager_Adapter extends FragmentPagerAdapter{

    List<Fragment> list;

    FragmentManager manager;

    public Pager_Adapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list = list;
        manager = fm;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
