package com.example.wtl.foursage20.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wtl.foursage20.R;

public class EditDynamicActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView edit_dynamic_back;

    private TextView edit_dynamic_push;

    private LinearLayout edit_dynamic_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dynamic);
        Montior();
    }

    private void Montior() {
        edit_dynamic_back = (ImageView) findViewById(R.id.edit_dynamic_back);
        edit_dynamic_push = (TextView) findViewById(R.id.edit_dynamic_push);
        edit_dynamic_picture = (LinearLayout) findViewById(R.id.edit_dynamic_picture);

        edit_dynamic_back.setOnClickListener(this);
        edit_dynamic_push.setOnClickListener(this);
        edit_dynamic_picture.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_dynamic_back:
                finish();
                //手动回收软键盘
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                break;
            default:
                break;
        }
    }
}
