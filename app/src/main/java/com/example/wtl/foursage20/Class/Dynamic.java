package com.example.wtl.foursage20.Class;

/**
 * 动态类
 * Created by WTL on 2018/3/12.
 */

public class Dynamic {

    private int dynamic_head;//动态发送者头像

    private String dynamic_name;//动态发送者名字

    private int dynamic_sex;//动态发送者性别

    private String dynamic_age;//动态发送者年龄

    private String dynamic_city;//动态发送者所在城市

    private String dynamic_university;//动态发送者所在学校

    private String send_time_dynamic;//动态发送的时间

    private String dynamic_context;//动态内容

    private String look_number_dynamic;//浏览次数

    private String act_good_num_dynamic;//点赞次数

    private String act_message_num_dynamic;//评论次数

    private String turn_num_dynamic;//转发次数

    public Dynamic(int dynamic_head,String dynamic_name,int dynamic_sex,String dynamic_age,String dynamic_city,
                   String dynamic_university,String send_time_dynamic,String dynamic_context,String look_number_dynamic,
                   String act_good_num_dynamic,String act_message_num_dynamic,String turn_num_dynamic) {
        this.dynamic_head = dynamic_head;
        this.dynamic_name = dynamic_name;
        this.dynamic_sex = dynamic_sex;
        this.dynamic_age = dynamic_age;
        this.dynamic_city = dynamic_city;
        this.dynamic_university = dynamic_university;
        this.send_time_dynamic = send_time_dynamic;
        this.dynamic_context = dynamic_context;
        this.look_number_dynamic = look_number_dynamic;
        this.act_good_num_dynamic = act_good_num_dynamic;
        this.act_message_num_dynamic = act_message_num_dynamic;
        this.turn_num_dynamic = turn_num_dynamic;
    }

    public int getDynamic_head() {
        return dynamic_head;
    }

    public int getDynamic_sex() {
        return dynamic_sex;
    }

    public String getAct_good_num_dynamic() {
        return act_good_num_dynamic;
    }

    public String getAct_message_num_dynamic() {
        return act_message_num_dynamic;
    }

    public String getDynamic_age() {
        return dynamic_age;
    }

    public String getDynamic_city() {
        return dynamic_city;
    }

    public String getDynamic_context() {
        return dynamic_context;
    }

    public String getDynamic_name() {
        return dynamic_name;
    }

    public String getDynamic_university() {
        return dynamic_university;
    }

    public String getLook_number_dynamic() {
        return look_number_dynamic;
    }

    public String getSend_time_dynamic() {
        return send_time_dynamic;
    }

    public String getTurn_num_dynamic() {
        return turn_num_dynamic;
    }
}
