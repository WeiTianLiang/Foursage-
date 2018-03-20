package com.example.wtl.foursage20.AdapterFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wtl.foursage20.Adapter.ReplayAdapter;
import com.example.wtl.foursage20.Class.Replay;
import com.example.wtl.foursage20.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 一级回复碎片
 * Created by WTL on 2018/3/19.
 */

public class FirstReplayFragment extends Fragment{

    private List<Replay> replayList = new ArrayList<>();

    private RecyclerView all_recycleview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_recycleview,container,false);
        initReplay();
        all_recycleview = (RecyclerView) view.findViewById(R.id.all_recycleview);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        all_recycleview.setLayoutManager(manager);
        ReplayAdapter adapter = new ReplayAdapter(getContext(),replayList);
        all_recycleview.setAdapter(adapter);
        return view;
    }

    private void initReplay() {
        Replay replay = new Replay(R.mipmap.act_head,"小明",R.mipmap.boy,"19","西安","西安邮电大学","牛比啊兄弟");
        replayList.add(replay);
        Replay replay1 = new Replay(R.mipmap.act_head,"小明",R.mipmap.boy,"19","西安","西安邮电大学","牛比啊兄弟");
        replayList.add(replay1);
        Replay replay2 = new Replay(R.mipmap.act_head,"小明",R.mipmap.boy,"19","西安","西安邮电大学","牛比啊兄弟");
        replayList.add(replay2);
    }

}
