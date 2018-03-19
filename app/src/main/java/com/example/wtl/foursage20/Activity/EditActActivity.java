package com.example.wtl.foursage20.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.wtl.foursage20.R;

import java.util.ArrayList;
import java.util.List;

public class EditActActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView edit_act_back;//返回

    private ImageView edit_acter_head;//编辑头像

    private TextView edit_acter_name;//编辑姓名

    private ImageView edit_acter_sex;//编辑性别

    private TextView edit_acter_age;//编辑年龄

    private TextView edit_acter_city;//编辑城市

    private TextView edit_acter_university;//编辑学校

    private EditText edit_act_name;//编辑活动名

    private Spinner edit_act_class;//编辑种类

    private EditText edit_act_time;//编辑时间

    private EditText edit_act_numb;//编辑人数

    private EditText edit_act_locate;//编辑地点

    private EditText edit_act_content;//编辑内容

    private Button edit_Publish_button;//完成

    private List<String> list;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_act);
        Monitor();
        init();
    }

    private void Monitor() {
        edit_act_back = (ImageView) findViewById(R.id.edit_act_back);
        edit_acter_head = (ImageView) findViewById(R.id.edit_acter_head);
        edit_acter_name = (TextView) findViewById(R.id.edit_acter_name);
        edit_acter_sex = (ImageView) findViewById(R.id.edit_acter_sex);
        edit_acter_age = (TextView) findViewById(R.id.edit_acter_age);
        edit_acter_city = (TextView) findViewById(R.id.edit_acter_city);
        edit_acter_university = (TextView) findViewById(R.id.edit_acter_university);
        edit_act_name = (EditText) findViewById(R.id.edit_act_name);
        edit_act_class = (Spinner) findViewById(R.id.edit_act_class);
        edit_act_time = (EditText) findViewById(R.id.edit_act_time);
        edit_act_numb = (EditText) findViewById(R.id.edit_act_numb);
        edit_act_locate = (EditText) findViewById(R.id.edit_act_locate);
        edit_act_content = (EditText) findViewById(R.id.edit_act_content);
        edit_Publish_button = (Button) findViewById(R.id.edit_Publish_button);

        edit_act_back.setOnClickListener(this);
        edit_Publish_button.setOnClickListener(this);
    }

    private void init() {
        list = new ArrayList<>();
        list.add("观影约饭");
        list.add("体育运动");
        list.add("户外旅行");
        list.add("健身跑步");
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edit_act_class.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_act_back:
                finish();
                //手动回收软键盘
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                break;
            case R.id.edit_Publish_button:
                break;
            default:
                break;
        }
    }
}
