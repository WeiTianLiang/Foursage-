package com.example.wtl.foursage20.LoadFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wtl.foursage20.Adapter.Pager_Adapter;
import com.example.wtl.foursage20.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 大众点评加载fragment
 * Created by WTL on 2018/3/7.
 */

public class Public_Comment_Fragment extends Fragment implements View.OnClickListener {

    private TextView Main_Act;//活动

    private TextView Main_Dynamic;//动态

    private Act_Fragment actfragment;//活动碎片

    private Dynamic_Fragment dynamicFragment;//动态碎片

    private View view;

    private ViewPager viewPager;

    private List<Fragment> fragmentList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.public_comment_title,container,false);
        Monitor();
        fragmentList.add(new Act_Fragment());
        fragmentList.add(new Dynamic_Fragment());
        FragmentManager manager = getFragmentManager();
        Pager_Adapter adapter = new Pager_Adapter(manager,fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Slip_jump_Public();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    /*监听控件*/
    private void Monitor() {
        Main_Act = (TextView) view.findViewById(R.id.Main_Act);
        Main_Dynamic = (TextView) view.findViewById(R.id.Main_Dynamic);
        viewPager = (ViewPager) view.findViewById(R.id.Public_Comment_pager);

        Main_Act.setOnClickListener(this);
        Main_Dynamic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Main_Act:
                viewPager.setCurrentItem(0);
                Main_Act.setTextColor(0xffffffff);
                Main_Dynamic.setTextColor(0xff000000);
                break;
            case R.id.Main_Dynamic:
                viewPager.setCurrentItem(1);
                Main_Act.setTextColor(0xff000000);
                Main_Dynamic.setTextColor(0xffffffff);
                break;
            default:
                break;
        }
    }

    public void Slip_jump_Public() {
        if(viewPager.getCurrentItem() == 0) {
            //字体颜色
            Main_Act.setTextColor(0xffffffff);
            Main_Dynamic.setTextColor(0xff000000);
        } else if(viewPager.getCurrentItem() == 1) {
            //字体颜色
            viewPager.setCurrentItem(1);
            Main_Act.setTextColor(0xff000000);
            Main_Dynamic.setTextColor(0xffffffff);
        }
    }

}
