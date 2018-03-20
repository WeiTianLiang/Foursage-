package com.example.wtl.foursage20.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wtl.foursage20.Class.Replay;
import com.example.wtl.foursage20.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 一级回复适配器
 * Created by WTL on 2018/3/18.
 */

public class ReplayAdapter extends RecyclerView.Adapter<ReplayAdapter.ViewHolder>{

    private List<Replay> list;

    private Context context;

    public ReplayAdapter(Context context,List<Replay> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ReplayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.details_card,null,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ReplayAdapter.ViewHolder holder, int position) {
        Replay replay = list.get(position);
        holder.detailer_head.setImageResource(replay.getDetailer_head());
        holder.detailer_name.setText(replay.getDetailer_name());
        holder.detailer_sex.setImageResource(replay.getDetailer_sex());
        holder.detailer_age.setText(replay.getDetailer_age());
        holder.detailer_city.setText(replay.getDetailer_city());
        holder.detailer_university.setText(replay.getDetailer_university());
        holder.detailer_back_content.setText(replay.getDetailer_back_content());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView detailer_head;

        TextView detailer_name;

        ImageView detailer_sex;

        TextView detailer_age;

        TextView detailer_city;

        TextView detailer_university;

        TextView detailer_back_content;

        public ViewHolder(View itemView) {
            super(itemView);
            detailer_head = (CircleImageView) itemView.findViewById(R.id.detailer_head);
            detailer_name = (TextView) itemView.findViewById(R.id.detailer_name);
            detailer_sex = (ImageView) itemView.findViewById(R.id.detailer_sex);
            detailer_age = (TextView) itemView.findViewById(R.id.detailer_age);
            detailer_city = (TextView) itemView.findViewById(R.id.detailer_city);
            detailer_university = (TextView) itemView.findViewById(R.id.detailer_university);
            detailer_back_content = (TextView) itemView.findViewById(R.id.detailer_back_content);
        }
    }
}
