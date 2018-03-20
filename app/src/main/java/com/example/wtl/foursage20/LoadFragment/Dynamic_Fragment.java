package com.example.wtl.foursage20.LoadFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wtl.foursage20.Activity.EditDynamicActivity;
import com.example.wtl.foursage20.Activity.MainActivity;
import com.example.wtl.foursage20.Adapter.Pager_Adapter;
import com.example.wtl.foursage20.AdapterFragment.Dynamic_All_Fragment;
import com.example.wtl.foursage20.AdapterFragment.Dynamic_City_Fragment;
import com.example.wtl.foursage20.AdapterFragment.Dynamic_Follow_Fragment;
import com.example.wtl.foursage20.AdapterFragment.Dynamic_Recommend_Fragment;
import com.example.wtl.foursage20.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态加载碎片
 * Created by WTL on 2018/3/7.
 */

public class Dynamic_Fragment extends Fragment implements View.OnClickListener{

    private TextView Dynamic_Recommend;

    private TextView Dynamic_Follow;

    private TextView Dynamic_City;

    private TextView Dynamic_All;

    private ImageView Dynamic_Recommend_skip;

    private ImageView Dynamic_Follow_skip;

    private ImageView Dynamic_City_skip;

    private ImageView Dynamic_All_skip;

    private Dynamic_Recommend_Fragment dynamicRecommendFragment = new Dynamic_Recommend_Fragment();

    private Dynamic_Follow_Fragment dynamicFollowFragment = new Dynamic_Follow_Fragment();

    private Dynamic_City_Fragment dynamicCityFragment = new Dynamic_City_Fragment();

    private Dynamic_All_Fragment dynamicAllFragment = new Dynamic_All_Fragment();

    private ViewPager viewPager;

    private View view;

    private List<Fragment> fragmentList = new ArrayList<>();

    private float y1;

    private float y2;

    private FloatingActionButton dynamic_edit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dynamic_title,container,false);
        Monitor();//调用监听
        ((MainActivity)this.getActivity()).registerMytTouchListener(listener);
        fragmentList.add(dynamicRecommendFragment);
        fragmentList.add(dynamicFollowFragment);
        fragmentList.add(dynamicCityFragment);
        fragmentList.add(dynamicAllFragment);
        FragmentManager manager = getChildFragmentManager();
        Pager_Adapter adapter = new Pager_Adapter(manager,fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(4);//限定viewpager加载的个数防止重复加载造成item叠加
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Slip_jump_Dynamic();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        dynamic_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EditDynamicActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((MainActivity)this.getActivity()).dispathMyTouchListener(listener);
    }

    //手势监听
    MainActivity.MyTouchListener listener = new MainActivity.MyTouchListener() {
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                y1 = event.getY();
            }
            if (event.getAction() == MotionEvent.ACTION_UP) {
                y2 = event.getY();
                if (y1 - y2 > 50) {
                    dynamic_edit.hide();
                } else if (y2 - y1 > 50) {
                    dynamic_edit.show();
                }
            }
            return false;
        }
    };

    /*监听控件*/
    private void Monitor() {
        Dynamic_Recommend = (TextView) view.findViewById(R.id.Dynamic_Recommend);
        Dynamic_Follow = (TextView) view.findViewById(R.id.Dynamic_Follow);
        Dynamic_City = (TextView) view.findViewById(R.id.Dynamic_City);
        Dynamic_All = (TextView) view.findViewById(R.id.Dynamic_All);
        viewPager = (ViewPager) view.findViewById(R.id.dynamic_pager);
        Dynamic_Recommend_skip = (ImageView) view.findViewById(R.id.Dynamic_Recommend_skip);
        Dynamic_Follow_skip = (ImageView) view.findViewById(R.id.Dynamic_Follow_skip);
        Dynamic_City_skip = (ImageView) view.findViewById(R.id.Dynamic_City_skip);
        Dynamic_All_skip = (ImageView) view.findViewById(R.id.Dynamic_All_skip);
        dynamic_edit = (FloatingActionButton) view.findViewById(R.id.dynamic_edit);

        Dynamic_Recommend.setOnClickListener(this);
        Dynamic_Follow.setOnClickListener(this);
        Dynamic_City.setOnClickListener(this);
        Dynamic_All.setOnClickListener(this);
    }



    /*点击事件*/
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Dynamic_Recommend:
                //字体颜色
                Dynamic_Recommend.setTextColor(0xffE51C23);
                Dynamic_Follow.setTextColor(0xff343434);
                Dynamic_City.setTextColor(0xff343434);
                Dynamic_All.setTextColor(0xff343434);
                //当前fragment页
                viewPager.setCurrentItem(0);
                //文字下图标显示
                Dynamic_Recommend_skip.setVisibility(View.VISIBLE);
                Dynamic_Follow_skip.setVisibility(View.GONE);
                Dynamic_City_skip.setVisibility(View.GONE);
                Dynamic_All_skip.setVisibility(View.GONE);
                break;
            case R.id.Dynamic_Follow:
                //字体颜色
                Dynamic_Recommend.setTextColor(0xff343434);
                Dynamic_Follow.setTextColor(0xffE51C23);
                Dynamic_City.setTextColor(0xff343434);
                Dynamic_All.setTextColor(0xff343434);
                //当前fragment页
                viewPager.setCurrentItem(1);
                //文字下图标显示
                Dynamic_Recommend_skip.setVisibility(View.GONE);
                Dynamic_Follow_skip.setVisibility(View.VISIBLE);
                Dynamic_City_skip.setVisibility(View.GONE);
                Dynamic_All_skip.setVisibility(View.GONE);
                break;
            case R.id.Dynamic_City:
                //字体颜色
                Dynamic_Recommend.setTextColor(0xff343434);
                Dynamic_Follow.setTextColor(0xff343434);
                Dynamic_City.setTextColor(0xffE51C23);
                Dynamic_All.setTextColor(0xff343434);
                //当前fragment页
                viewPager.setCurrentItem(2);
                //文字下图标显示
                Dynamic_Recommend_skip.setVisibility(View.GONE);
                Dynamic_Follow_skip.setVisibility(View.GONE);
                Dynamic_City_skip.setVisibility(View.VISIBLE);
                Dynamic_All_skip.setVisibility(View.GONE);
                break;
            case R.id.Dynamic_All:
                //字体颜色
                Dynamic_Recommend.setTextColor(0xff343434);
                Dynamic_Follow.setTextColor(0xff343434);
                Dynamic_City.setTextColor(0xff343434);
                Dynamic_All.setTextColor(0xffE51C23);
                //当前fragment页
                viewPager.setCurrentItem(3);
                //文字下图标显示
                Dynamic_Recommend_skip.setVisibility(View.GONE);
                Dynamic_Follow_skip.setVisibility(View.GONE);
                Dynamic_City_skip.setVisibility(View.GONE);
                Dynamic_All_skip.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    /*
    * 滑动切换title
    * */
    public void Slip_jump_Dynamic() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if(viewPager.getCurrentItem() == 0) {
            //字体颜色
            Dynamic_Recommend.setTextColor(0xffE51C23);
            Dynamic_Follow.setTextColor(0xff343434);
            Dynamic_City.setTextColor(0xff343434);
            Dynamic_All.setTextColor(0xff343434);
            //文字下图标显示
            Dynamic_Recommend_skip.setVisibility(View.VISIBLE);
            Dynamic_Follow_skip.setVisibility(View.GONE);
            Dynamic_City_skip.setVisibility(View.GONE);
            Dynamic_All_skip.setVisibility(View.GONE);
            //隐藏软件盘

        } else if(viewPager.getCurrentItem() == 1) {
            //字体颜色
            Dynamic_Recommend.setTextColor(0xff343434);
            Dynamic_Follow.setTextColor(0xffE51C23);
            Dynamic_City.setTextColor(0xff343434);
            Dynamic_All.setTextColor(0xff343434);
            //文字下图标显示
            Dynamic_Recommend_skip.setVisibility(View.GONE);
            Dynamic_Follow_skip.setVisibility(View.VISIBLE);
            Dynamic_City_skip.setVisibility(View.GONE);
            Dynamic_All_skip.setVisibility(View.GONE);
        } else if(viewPager.getCurrentItem() == 2) {
            //字体颜色
            Dynamic_Recommend.setTextColor(0xff343434);
            Dynamic_Follow.setTextColor(0xff343434);
            Dynamic_City.setTextColor(0xffE51C23);
            Dynamic_All.setTextColor(0xff343434);
            //文字下图标显示
            Dynamic_Recommend_skip.setVisibility(View.GONE);
            Dynamic_Follow_skip.setVisibility(View.GONE);
            Dynamic_City_skip.setVisibility(View.VISIBLE);
            Dynamic_All_skip.setVisibility(View.GONE);
        } else if(viewPager.getCurrentItem() == 3) {
            //字体颜色
            Dynamic_Recommend.setTextColor(0xff343434);
            Dynamic_Follow.setTextColor(0xff343434);
            Dynamic_City.setTextColor(0xff343434);
            Dynamic_All.setTextColor(0xffE51C23);
            //文字下图标显示
            Dynamic_Recommend_skip.setVisibility(View.GONE);
            Dynamic_Follow_skip.setVisibility(View.GONE);
            Dynamic_City_skip.setVisibility(View.GONE);
            Dynamic_All_skip.setVisibility(View.VISIBLE);
        }
    }
}
