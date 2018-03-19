package com.example.wtl.foursage20.Class;

/**
 * 一级回复类
 * Created by WTL on 2018/3/18.
 */

public class Replay {

    private int detailer_head;

    private String detailer_name;

    private int detailer_sex;

    private String detailer_age;

    private String detailer_city;

    private String detailer_university;

    private String detailer_back_content;

    public Replay(int detailer_head,String detailer_name,int detailer_sex,String detailer_age,
                  String detailer_city,String detailer_university,String detailer_back_content) {
        this.detailer_head = detailer_head;
        this.detailer_name = detailer_name;
        this.detailer_sex = detailer_sex;
        this.detailer_age = detailer_age;
        this.detailer_city = detailer_city;
        this.detailer_university = detailer_university;
        this.detailer_back_content = detailer_back_content;
    }

    public int getDetailer_head() {
        return detailer_head;
    }

    public int getDetailer_sex() {
        return detailer_sex;
    }

    public String getDetailer_age() {
        return detailer_age;
    }

    public String getDetailer_back_content() {
        return detailer_back_content;
    }

    public String getDetailer_city() {
        return detailer_city;
    }

    public String getDetailer_name() {
        return detailer_name;
    }

    public String getDetailer_university() {
        return detailer_university;
    }
}
