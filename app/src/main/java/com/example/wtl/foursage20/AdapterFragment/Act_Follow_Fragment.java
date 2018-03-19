package com.example.wtl.foursage20.AdapterFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wtl.foursage20.Activity.MainActivity;
import com.example.wtl.foursage20.Adapter.All_Act_Adapter;
import com.example.wtl.foursage20.Class.Act;
import com.example.wtl.foursage20.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动-关注：碎片
 * Created by WTL on 2018/3/7.
 */

public class Act_Follow_Fragment extends Fragment {

    private List<Act> actList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_recycleview,container,false);
        /*((MainActivity)this.getActivity()).registerMytTouchListener(listener);*/
        init_Act_content();//添加数据
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.all_recycleview);//获取recycleview布局
        /*默认删除动画*/
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setRemoveDuration(250);
        recyclerView.setItemAnimator(animator);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());//创建测量布局
        recyclerView.setLayoutManager(layoutManager);//添加给recycleview
        final All_Act_Adapter allActAdapter = new All_Act_Adapter(actList,getContext());//创建适配器
        recyclerView.setAdapter(allActAdapter);//添加适配器
        return view;
    }

    //添加数据
    public void init_Act_content() {
        Act act = new Act(R.mipmap.act_head,"小明",R.mipmap.boy,"19","西安","西安邮电大学","今天13:00","找人打羽毛球",
                "体育运动","2018年3月4日  13:00","西安邮电大学羽毛球场","1","2",R.mipmap.participate,"100","100","1300");
        actList.add(act);
        Act act1 = new Act(R.mipmap.act_head,"敢死队风格",R.mipmap.boy,"18","西安","西安邮电大学","今天13:00","找人打羽毛球",
                "体育运动","2018年3月4日  13:00","西安邮电大学羽毛球场","1","2",R.mipmap.participate,"100","100","1300");
        actList.add(act1);
        Act act2 = new Act(R.mipmap.act_head,"asdfsadf",R.mipmap.boy,"19","西安","西安邮电大学","今天13:00","找人打羽毛球",
                "体育运动","2018年3月4日  13:00","西安邮电大学羽毛球场","1","2",R.mipmap.participate,"100","100","1300");
        actList.add(act2);
        Act act3 = new Act(R.mipmap.act_head,"在v向公司仍然",R.mipmap.boy,"18","西安","西安邮电大学","今天13:00","找人打羽毛球",
                "体育运动","2018年3月4日  13:00","西安邮电大学羽毛球场","1","2",R.mipmap.participate,"100","100","1300");
        actList.add(act3);
    }
}