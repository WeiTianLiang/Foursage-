package com.example.wtl.foursage20.AdapterFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wtl.foursage20.Adapter.All_Dynamic_Adapter;
import com.example.wtl.foursage20.Class.Dynamic;
import com.example.wtl.foursage20.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态关注碎片
 * Created by WTL on 2018/3/12.
 */

public class Dynamic_Follow_Fragment extends Fragment{

    private List<Dynamic> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_recycleview,container,false);
        init_dynamic_recommend();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.all_recycleview);
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setAddDuration(250);
        recyclerView.setItemAnimator(animator);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        All_Dynamic_Adapter adapter = new All_Dynamic_Adapter(getContext(),list);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void init_dynamic_recommend() {
        Dynamic dynamic1 = new Dynamic(R.mipmap.act_head,"小li",R.mipmap.boy,"19","西安","西安邮电大学","今天13:00","找从随时报告vv viu试试vui莪媞人iesuv欸v死viesvital是viv死活题view","100","100","100","100");
        list.add(dynamic1);
        Dynamic dynamic2 = new Dynamic(R.mipmap.act_head,"小sadf",R.mipmap.boy,"19","西安","西安邮电大学","今天13:00","找从随时报告vv viu试试vui莪媞人iesuv欸v死viesvital是viv死活题view","100","100","100","100");
        list.add(dynamic2);
        Dynamic dynamic3 = new Dynamic(R.mipmap.act_head,"小gsg",R.mipmap.boy,"19","西安","西安邮电大学","今天13:00","找从随时报告vv viu试试vui莪媞人iesuv欸v死viesvital是viv死活题view","100","100","100","100");
        list.add(dynamic3);
    }

}
