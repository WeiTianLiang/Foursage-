package com.example.wtl.foursage20.Class;

/**
 * 二级回复类
 * Created by WTL on 2018/3/20.
 */

public class Replay_Second {

    private String detailer_sec_name;

    private String back_detailer_sec_name;

    private String back_detailer_content;

    public Replay_Second(String detailer_sec_name,String back_detailer_sec_name,String back_detailer_content) {
        this.detailer_sec_name = detailer_sec_name;
        this.back_detailer_sec_name = back_detailer_sec_name;
        this.back_detailer_content = back_detailer_content;
    }

    public String getBack_detailer_content() {
        return back_detailer_content;
    }

    public String getBack_detailer_sec_name() {
        return back_detailer_sec_name;
    }

    public String getDetailer_sec_name() {
        return detailer_sec_name;
    }
}
