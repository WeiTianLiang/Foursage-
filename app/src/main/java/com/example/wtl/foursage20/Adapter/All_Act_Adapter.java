package com.example.wtl.foursage20.Adapter;

/**
 * 所有活动适配器
 * Created by WTL on 2018/3/7.
 */

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wtl.foursage20.Activity.DetailsActActivity;
import com.example.wtl.foursage20.Activity.EditActActivity;
import com.example.wtl.foursage20.Activity.MainActivity;
import com.example.wtl.foursage20.Class.Act;
import com.example.wtl.foursage20.R;
import com.example.wtl.foursage20.Tool.Drop_Down_Dialog;
import com.example.wtl.foursage20.Tool.Good_Animation;

import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

public class All_Act_Adapter extends RecyclerView.Adapter<All_Act_Adapter.ViewHolder>{

    private List<Act> actList;//创建列表

    private Context context;

    private Drop_Down_Dialog dropDownDialog;

    //创建引用函数
    public All_Act_Adapter(List<Act> actlist,Context context) {
        this.actList = actlist;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*从context中获取一个布局填充器将xml转换成view*/
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.act_card,parent,false);
        /*将view赋给viewHolder对象*/
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        /*指向当前选中位置*/
        Act act = actList.get(position);
        /*添加数据*/
        holder.acter_head.setImageResource(act.getActer_head());
        holder.acter_name.setText(act.getActer_name());
        holder.acter_sex.setImageResource(act.getActer_sex());
        holder.acter_age.setText(act.getActer_age());
        holder.acter_city.setText(act.getActer_city());
        holder.acter_university.setText(act.getActer_university());
        holder.send_time.setText(act.getSend_time());
        holder.act_name.setText(act.getAct_name());
        holder.act_type.setText(act.getAct_type());
        holder.act_begin_time.setText(act.getAct_begin_time());
        holder.act_place.setText(act.getAct_place());
        holder.now_people_number.setText(act.getNow_people_number());
        holder.all_people_number.setText(act.getAll_people_number());
        holder.join_head.setImageResource(act.getJoin_head());
        holder.look_number.setText(act.getLook_number());
        holder.act_good_num.setText(act.getAct_good_num());
        holder.act_message_num.setText(act.getAct_message_num());
        /*实现下拉框*/
        holder.drop_down_img.setOnClickListener(new View.OnClickListener() {
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
        holder.act_good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.act_good.getDrawable().getCurrent().getConstantState().equals(context.getResources().getDrawable(R.mipmap.act_good).getConstantState())) {
                    holder.act_good.setImageResource(R.mipmap.touch_act_good);
                    Good_Animation.Enlarge(holder.act_good);
                } else {
                    holder.act_good.setImageResource(R.mipmap.act_good);
                }
            }
        });

        holder.detailed_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return actList.size();
    }

    //删除节点
    public void delete(int postion) {
        actList.remove(postion);
        notifyItemRemoved(postion);
        notifyItemRangeChanged(postion, actList.size() - postion);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        /*获取数据的*/
        CircleImageView acter_head;//活动发送者头像

        TextView acter_name;//活动发送者名字

        ImageView acter_sex;//活动发送者性别

        TextView acter_age;//活动发送者年龄

        TextView acter_city;//活动发送者所在城市

        TextView acter_university;//活动发送者所在学校

        TextView send_time;//活动发送的时间

        TextView act_name;//当前活动的名称

        TextView act_type;//当前活动的类型

        TextView act_begin_time;//当前活动开始时间

        TextView act_place;//当前活动的地址

        TextView now_people_number;//已报名人数

        TextView all_people_number;//活动的最大人数

        CircleImageView join_head;//参加人的头像

        TextView look_number;//浏览次数

        TextView act_good_num;//点赞次数

        TextView act_message_num;//评论次数

        /*实现功能的*/

        ImageView act_good;//点赞

        ImageView drop_down_img;//下拉框图标

        LinearLayout detailed_act;//进入详情

        public ViewHolder(View view) {
            super(view);
            acter_head = (CircleImageView) view.findViewById(R.id.acter_head);
            acter_name = (TextView) view.findViewById(R.id.acter_name);
            acter_sex = (ImageView) view.findViewById(R.id.acter_sex);
            acter_age = (TextView) view.findViewById(R.id.acter_age);
            acter_city = (TextView) view.findViewById(R.id.acter_city);
            acter_university = (TextView) view.findViewById(R.id.acter_university);
            send_time = (TextView) view.findViewById(R.id.send_time);
            act_name = (TextView) view.findViewById(R.id.act_name);
            act_type = (TextView) view.findViewById(R.id.act_type);
            act_begin_time = (TextView) view.findViewById(R.id.act_begin_time);
            act_place = (TextView) view.findViewById(R.id.act_place);
            now_people_number = (TextView) view.findViewById(R.id.now_people_number);
            all_people_number = (TextView) view.findViewById(R.id.all_people_number);
            join_head = (CircleImageView) view.findViewById(R.id.join_head);
            look_number = (TextView) view.findViewById(R.id.look_number);
            act_good_num = (TextView) view.findViewById(R.id.act_good_num);
            act_message_num = (TextView) view.findViewById(R.id.act_message_num);
            act_good = (ImageView) view.findViewById(R.id.act_good);
            drop_down_img = (ImageView) view.findViewById(R.id.drop_down_img);
            detailed_act = (LinearLayout) view.findViewById(R.id.detailed_act);
        }
    }
}
