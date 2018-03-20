package com.example.wtl.foursage20.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wtl.foursage20.Class.Replay_Second;
import com.example.wtl.foursage20.R;

import java.util.List;

/**
 * 二级回复适配器
 * Created by WTL on 2018/3/20.
 */

public class Replay_Second_Adapter extends RecyclerView.Adapter<Replay_Second_Adapter.ViewHolder>{

    private List<Replay_Second> list;

    private Context context;

    public Replay_Second_Adapter(List<Replay_Second> list,Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Replay_Second_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.details_second_card,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Replay_Second_Adapter.ViewHolder holder, int position) {
        Replay_Second replay_second = list.get(position);
        holder.detailer_sec_name.setText(replay_second.getDetailer_sec_name());
        holder.back_detailer_sec_name.setText(replay_second.getBack_detailer_sec_name());
        holder.back_detailer_content.setText(replay_second.getBack_detailer_content());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView detailer_sec_name;

        TextView back_detailer_sec_name;

        TextView back_detailer_content;

        public ViewHolder(View itemView) {
            super(itemView);
            detailer_sec_name = (TextView) itemView.findViewById(R.id.detailer_sec_name);
            back_detailer_sec_name = (TextView) itemView.findViewById(R.id.back_detailer_sec_name);
            back_detailer_content = (TextView) itemView.findViewById(R.id.back_detailer_content);
        }
    }
}
