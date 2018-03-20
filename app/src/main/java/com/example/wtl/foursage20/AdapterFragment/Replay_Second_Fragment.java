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
import com.example.wtl.foursage20.Adapter.Replay_Second_Adapter;
import com.example.wtl.foursage20.Class.Replay;
import com.example.wtl.foursage20.Class.Replay_Second;
import com.example.wtl.foursage20.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 二级回复碎片
 * Created by WTL on 2018/3/20.
 */

public class Replay_Second_Fragment extends Fragment{

    private List<Replay_Second> replay_secondList = new ArrayList<>();

    private RecyclerView all_recycleview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_recycleview,container,false);
        initReplay();
        all_recycleview = (RecyclerView) view.findViewById(R.id.all_recycleview);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        all_recycleview.setLayoutManager(manager);
        Replay_Second_Adapter adapter = new Replay_Second_Adapter(replay_secondList,getContext());
        all_recycleview.setAdapter(adapter);
        return view;
    }

    private void initReplay() {
        Replay_Second replay = new Replay_Second("小妹","小明","dasdasdasdasdasdas");
        replay_secondList.add(replay);
        Replay_Second replay1 = new Replay_Second("小妹","小明","dasdasdasdasdasdas");
        replay_secondList.add(replay1);
        Replay_Second replay2 = new Replay_Second("小妹","小明","dasdasdasdasdasdas");
        replay_secondList.add(replay2);
    }

}
