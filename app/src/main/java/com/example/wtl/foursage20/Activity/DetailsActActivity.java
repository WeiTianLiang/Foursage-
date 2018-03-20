package com.example.wtl.foursage20.Activity;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.wtl.foursage20.AdapterFragment.FirstReplayFragment;
import com.example.wtl.foursage20.R;
import com.example.wtl.foursage20.Tool.Soft_Keyboard_Tool;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActActivity extends AppCompatActivity implements View.OnClickListener {

    private FirstReplayFragment firstReplayFragment;

    private FragmentManager manager;

    private FragmentTransaction transaction;

    private EditText details_talk_message;

    private ImageView details_back;

    private CircleImageView details_head;

    private Button details_talk_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_act);
        Montior();
        upload();
        Soft_Keyboard_Tool.setListener(DetailsActActivity.this, new Soft_Keyboard_Tool.OnSoftKeyBoardChangeListener() {
            @Override
            public void keyBoardShow(int height) {
                details_talk_button.setVisibility(View.VISIBLE);
            }

            @Override
            public void keyBoardHide(int height) {
                details_talk_button.setVisibility(View.GONE);
            }
        });
    }

    //从xml文件获取控件
    private void Montior() {
        details_talk_message = (EditText) findViewById(R.id.details_talk_message);
        details_back = (ImageView) findViewById(R.id.details_back);
        details_head = (CircleImageView) findViewById(R.id.details_acter_head);
        details_talk_button = (Button) findViewById(R.id.details_talk_button);

        //给最顶部的一个控件设置焦点从而防止从底部加载的情况出现
        details_head.setFocusable(true);
        details_head.setFocusableInTouchMode(true);
        details_head.requestFocus();

        details_back.setOnClickListener(this);
        details_talk_button.setOnClickListener(this);
    }

    //加载一级回复fragment
    private void upload() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        if(firstReplayFragment != null) {
            transaction.hide(firstReplayFragment);
        }
        if(firstReplayFragment == null) {
            firstReplayFragment = new FirstReplayFragment();
            transaction.add(R.id.reply,firstReplayFragment);
        } else {
            transaction.show(firstReplayFragment);
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.details_back:
                finish();
                InputMethodManager methodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                methodManager.hideSoftInputFromInputMethod(getWindow().getDecorView().getWindowToken(),0);
                break;
            case R.id.details_talk_button:

                break;
        }
    }

}
