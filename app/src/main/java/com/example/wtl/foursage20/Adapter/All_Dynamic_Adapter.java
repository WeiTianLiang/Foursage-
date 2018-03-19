package com.example.wtl.foursage20.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wtl.foursage20.Class.Dynamic;
import com.example.wtl.foursage20.R;
import com.example.wtl.foursage20.Tool.Drop_Down_Dialog;
import com.example.wtl.foursage20.Tool.Good_Animation;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 动态适配器
 * Created by WTL on 2018/3/12.
 */

public class All_Dynamic_Adapter extends RecyclerView.Adapter<All_Dynamic_Adapter.ViewHolder> {

    private List<Dynamic> list;

    private Context context;

    private Drop_Down_Dialog dropDownDialog;

    public All_Dynamic_Adapter(Context context,List<Dynamic> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public All_Dynamic_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dynamic_card,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Dynamic dynamic = list.get(position);
        //获取数据
        holder.dynamic_head.setImageResource(dynamic.getDynamic_head());
        holder.dynamic_name.setText(dynamic.getDynamic_name());
        holder.dynamic_sex.setImageResource(dynamic.getDynamic_sex());
        holder.dynamic_age.setText(dynamic.getDynamic_age());
        holder.dynamic_city.setText(dynamic.getDynamic_city());
        holder.dynamic_university.setText(dynamic.getDynamic_university());
        holder.send_time_dynamic.setText(dynamic.getSend_time_dynamic());
        holder.dynamic_context.setText(dynamic.getDynamic_context());
        holder.look_number_dynamic.setText(dynamic.getLook_number_dynamic());
        holder.good_num_dynamic.setText(dynamic.getAct_good_num_dynamic());
        holder.message_num_dynamic.setText(dynamic.getAct_message_num_dynamic());
        holder.turn_num_dynamic.setText(dynamic.getTurn_num_dynamic());

        /*实现下拉框*/
        holder.drop_down_img_dynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropDownDialog = new Drop_Down_Dialog(context);
                dropDownDialog.show();
                Window window = dropDownDialog.getWindow();
                window.setGravity(Gravity.CENTER);
                dropDownDialog.setdeleteOnClickListener(new Drop_Down_Dialog.ondeleteOnClickListener() {
                    @Override
                    public void ondeleteClick() {
                        delete(position);
                        dropDownDialog.dismiss();
                    }
                });
            }
        });

        /*实现点赞评论*/
        holder.good_dynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.good_dynamic.getDrawable().getCurrent().getConstantState().equals(context.getResources().getDrawable(R.mipmap.act_good).getConstantState())) {
                    holder.good_dynamic.setImageResource(R.mipmap.touch_act_good);
                    Good_Animation.Enlarge(holder.good_dynamic);
                } else {
                    holder.good_dynamic.setImageResource(R.mipmap.act_good);
                }
            }
        });


    }

    //删除节点
    public void delete(int postion) {
        list.remove(postion);
        notifyItemRemoved(postion);
        notifyItemRangeChanged(postion, list.size() - postion);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView dynamic_head;//动态发送者头像

        TextView dynamic_name;//动态发送者名字

        ImageView dynamic_sex;//动态发送者性别

        TextView dynamic_age;//动态发送者年龄

        TextView dynamic_city;//动态发送者所在城市

        TextView dynamic_university;//动态发送者所在学校

        TextView send_time_dynamic;//动态发送的时间

        TextView dynamic_context;//动态内容

        TextView look_number_dynamic;//动态浏览次数

        TextView good_num_dynamic;//动态点赞次数

        TextView message_num_dynamic;//动态评论次数

        TextView turn_num_dynamic;//动态转发次数

        /*实现功能的*/

        ImageView good_dynamic;//点赞

        ImageView drop_down_img_dynamic;//下拉框图标

        public ViewHolder(View view) {
            super(view);
            dynamic_head = (CircleImageView) view.findViewById(R.id.dynamic_head);
            dynamic_name = (TextView) view.findViewById(R.id.dynamic_name);
            dynamic_sex = (ImageView) view.findViewById(R.id.dynamic_sex);
            dynamic_age = (TextView) view.findViewById(R.id.dynamic_age);
            dynamic_city = (TextView) view.findViewById(R.id.dynamic_city);
            dynamic_university = (TextView) view.findViewById(R.id.dynamic_university);
            send_time_dynamic = (TextView) view.findViewById(R.id.send_time_dynamic);
            dynamic_context = (TextView) view.findViewById(R.id.dynamic_context);
            look_number_dynamic = (TextView) view.findViewById(R.id.look_number_dynamic);
            good_num_dynamic = (TextView) view.findViewById(R.id.good_num_dynamic);
            message_num_dynamic = (TextView) view.findViewById(R.id.message_num_dynamic);
            turn_num_dynamic = (TextView) view.findViewById(R.id.turn_num_dynamic);
            good_dynamic = (ImageView) view.findViewById(R.id.good_dynamic);
            drop_down_img_dynamic = (ImageView) view.findViewById(R.id.drop_down_img_dynamic);
        }

    }

}
