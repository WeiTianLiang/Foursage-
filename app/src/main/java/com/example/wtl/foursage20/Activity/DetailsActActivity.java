package com.example.wtl.foursage20.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.wtl.foursage20.AdapterFragment.FirstReplayFragment;
import com.example.wtl.foursage20.R;

public class DetailsActActivity extends AppCompatActivity implements View.OnClickListener {

    private FirstReplayFragment firstReplayFragment;

    private FragmentManager manager;

    private FragmentTransaction transaction;

    private EditText details_talk_message;

    private ImageView details_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_act);
        Montior();
        upload();
    }

    //从xml文件获取控件
    private void Montior() {
        details_talk_message = (EditText) findViewById(R.id.details_talk_message);
        details_back = (ImageView) findViewById(R.id.details_back);


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
                break;
        }
    }
}
