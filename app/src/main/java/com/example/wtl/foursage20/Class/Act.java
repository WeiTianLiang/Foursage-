package com.example.wtl.foursage20.Class;

/**
 * 活动类
 * Created by WTL on 2018/3/7.
 */

public class Act {

    private int acter_head;//活动发送者头像

    private String acter_name;//活动发送者名字

    private int acter_sex;//活动发送者性别

    private String acter_age;//活动发送者年龄

    private String acter_city;//活动发送者所在城市

    private String acter_university;//活动发送者所在学校

    private String send_time;//活动发送的时间

    private String act_name;//当前活动的名称

    private String act_type;//当前活动的类型

    private String act_begin_time;//当前活动开始时间

    private String act_place;//当前活动的地址

    private String now_people_number;//已报名人数

    private String all_people_number;//活动的最大人数

    private int join_head;//参加人的头像

    private String look_number;//浏览次数

    private String act_good_num;//点赞次数

    private String act_message_num;//评论次数

    public Act(int acter_head,String acter_name,int acter_sex,String acter_age,String acter_city,
               String acter_university,String send_time,String act_name,String act_type,String act_begin_time,
               String act_place,String now_people_number,String all_people_number,int join_head,String look_number,
               String act_good,String act_message) {
        this.acter_head = acter_head;
        this.acter_name = acter_name;
        this.acter_sex = acter_sex;
        this.acter_age = acter_age;
        this.acter_city = acter_city;
        this.acter_university = acter_university;
        this.send_time = send_time;
        this.act_name = act_name;
        this.act_type = act_type;
        this.act_begin_time = act_begin_time;
        this.act_place = act_place;
        this.now_people_number = now_people_number;
        this.all_people_number = all_people_number;
        this.join_head = join_head;
        this.look_number = look_number;
        this.act_good_num = act_good;
        this.act_message_num = act_message;
    }

    public int getActer_head() {
        return acter_head;
    }

    public int getActer_sex() {
        return acter_sex;
    }

    public String getAct_begin_time() {
        return act_begin_time;
    }

    public String getAct_name() {
        return act_name;
    }

    public String getAct_good_num() {
        return act_good_num;
    }

    public String getAct_place() {
        return act_place;
    }

    public String getAct_type() {
        return act_type;
    }

    public String getActer_age() {
        return acter_age;
    }

    public String getAct_message_num() {
        return act_message_num;
    }

    public String getActer_city() {
        return acter_city;
    }

    public String getActer_name() {
        return acter_name;
    }

    public String getActer_university() {
        return acter_university;
    }

    public String getAll_people_number() {
        return all_people_number;
    }

    public int getJoin_head() {
        return join_head;
    }

    public String getLook_number() {
        return look_number;
    }

    public String getNow_people_number() {
        return now_people_number;
    }

    public String getSend_time() {
        return send_time;
    }
}
