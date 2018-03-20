package com.example.wtl.foursage20.LoadFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

import com.example.wtl.foursage20.Activity.EditActActivity;
import com.example.wtl.foursage20.Activity.MainActivity;
import com.example.wtl.foursage20.Adapter.Pager_Adapter;
import com.example.wtl.foursage20.AdapterFragment.Act_Follow_Fragment;
import com.example.wtl.foursage20.AdapterFragment.Act_Recommend_Fragment;
import com.example.wtl.foursage20.AdapterFragment.Act_Screen_Fragment;
import com.example.wtl.foursage20.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动选择显示碎片
 * Created by WTL on 2018/3/7.
 */

public class Act_Fragment extends Fragment implements View.OnClickListener{

    private TextView Act_Follow;//活动关注

    private TextView Act_Recommend;//活动推荐

    private TextView Act_Screen;//活动筛选

    private Act_Follow_Fragment actFollowFragment = new Act_Follow_Fragment();//关注活动碎片

    private Act_Recommend_Fragment actRecommendFragment = new Act_Recommend_Fragment();//推荐活动碎片

    private Act_Screen_Fragment actScreenFragment = new Act_Screen_Fragment();//筛选活动碎片

    private List<Fragment> fragmentList = new ArrayList<>();

    private View view;

    private ViewPager pager;

    private ImageView skip_line_follow;//滑动图片

    private ImageView skip_line_recommend;

    private ImageView skip_line_screen;

    private FloatingActionButton act_edit;//创建活动

    private float y1 = 0;
    private float y2 = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.act_title,container,false);
        Monitor();//调用监听
        ((MainActivity)this.getActivity()).registerMytTouchListener(listener);
        fragmentList.add(actFollowFragment);
        fragmentList.add(actRecommendFragment);
        fragmentList.add(actScreenFragment);
        FragmentManager manager = getChildFragmentManager();
        Pager_Adapter adapter = new Pager_Adapter(manager,fragmentList);
        pager.setAdapter(adapter);
        pager.setCurrentItem(0);
        pager.setOffscreenPageLimit(3);//限定viewpager加载的个数防止重复加载造成item叠加
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Slip_jump_Act();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        act_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditActActivity.class);
                startActivity(intent);
            }
        });

        return view;
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
                    act_edit.hide();
                } else if (y2 - y1 > 50) {
                    act_edit.show();
                }
            }
            return false;
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((MainActivity)this.getActivity()).dispathMyTouchListener(listener);
    }

    /*监听控件*/
    private void Monitor() {
        Act_Follow = (TextView) view.findViewById(R.id.Act_Follow);
        Act_Recommend = (TextView) view.findViewById(R.id.Act_Recommend);
        Act_Screen = (TextView) view.findViewById(R.id.Act_Screen);
        pager = (ViewPager) view.findViewById(R.id.title2_pager);
        skip_line_follow = (ImageView) view.findViewById(R.id.skip_line_follow);
        skip_line_recommend = (ImageView) view.findViewById(R.id.skip_line_recommend);
        skip_line_screen = (ImageView) view.findViewById(R.id.skip_line_screen);
        act_edit = (FloatingActionButton) view.findViewById(R.id.act_edit);

        Act_Follow.setOnClickListener(this);
        Act_Recommend.setOnClickListener(this);
        Act_Screen.setOnClickListener(this);
    }

    /*
    *点击事件
    * */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Act_Follow:
                //字体颜色
                Act_Follow.setTextColor(0xffE51C23);
                Act_Recommend.setTextColor(0xff343434);
                Act_Screen.setTextColor(0xff343434);
                //当前fragment页
                pager.setCurrentItem(0);
                //文字下图标显示
                skip_line_follow.setVisibility(View.VISIBLE);
                skip_line_recommend.setVisibility(View.GONE);
                skip_line_screen.setVisibility(View.GONE);
                break;
            case R.id.Act_Recommend:
                //字体颜色
                Act_Follow.setTextColor(0xff343434);
                Act_Recommend.setTextColor(0xffE51C23);
                Act_Screen.setTextColor(0xff343434);
                //当前fragment页
                pager.setCurrentItem(1);
                //文字下图标显示
                skip_line_recommend.setVisibility(View.VISIBLE);
                skip_line_screen.setVisibility(View.GONE);
                skip_line_follow.setVisibility(View.GONE);
                break;
            case R.id.Act_Screen:
                //字体颜色
                Act_Follow.setTextColor(0xff343434);
                Act_Recommend.setTextColor(0xff343434);
                Act_Screen.setTextColor(0xffE51C23);
                //当前fragment页
                pager.setCurrentItem(2);
                //文字下图标显示
                skip_line_screen.setVisibility(View.VISIBLE);
                skip_line_follow.setVisibility(View.GONE);
                skip_line_recommend.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    /*
    * 滑动切换title
    * */
    public void Slip_jump_Act() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if(pager.getCurrentItem() == 0) {
            //字体颜色
            Act_Follow.setTextColor(0xffE51C23);
            Act_Recommend.setTextColor(0xff343434);
            Act_Screen.setTextColor(0xff343434);
            //文字下图标显示
            skip_line_follow.setVisibility(View.VISIBLE);
            skip_line_recommend.setVisibility(View.GONE);
            skip_line_screen.setVisibility(View.GONE);
            //手动回收软键盘
            imm.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
        } else if(pager.getCurrentItem() == 1) {
            //字体颜色
            Act_Follow.setTextColor(0xff343434);
            Act_Recommend.setTextColor(0xffE51C23);
            Act_Screen.setTextColor(0xff343434);
            //文字下图标显示
            skip_line_recommend.setVisibility(View.VISIBLE);
            skip_line_screen.setVisibility(View.GONE);
            skip_line_follow.setVisibility(View.GONE);
            //手动回收软键盘
            imm.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(),0);
        } else if(pager.getCurrentItem() == 2) {
            //字体颜色
            Act_Follow.setTextColor(0xff343434);
            Act_Recommend.setTextColor(0xff343434);
            Act_Screen.setTextColor(0xffE51C23);
            //文字下图标显示
            skip_line_screen.setVisibility(View.VISIBLE);
            skip_line_follow.setVisibility(View.GONE);
            skip_line_recommend.setVisibility(View.GONE);
            imm.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(),0);
        }
    }
}
