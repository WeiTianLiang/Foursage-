package com.example.wtl.foursage20.Tool;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.wtl.foursage20.R;

/**
 * 下拉框工具
 * Created by WTL on 2018/3/11.
 */

public class Drop_Down_Dialog extends Dialog{

    private Context context;

    private TextView follow_dialog;//关注

    private TextView delete_dialog;//删除

    private onfollowOnClickListener followOnClickListener;//自定义关注事件接口

    private ondeleteOnClickListener deleteOnClickListener;//自定义删除事件接口

    public Drop_Down_Dialog(@NonNull Context context) {
        super(context, R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drop_down);
        Minor();
        initEven();
    }

    private void Minor() {
        follow_dialog = (TextView) findViewById(R.id.follow_dialog);
        delete_dialog = (TextView) findViewById(R.id.delete_dialog);
    }

    //监听外界事件
    private void initEven() {
        follow_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                followOnClickListener.onfollowClick();
            }
        });
        delete_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteOnClickListener.ondeleteClick();
            }
        });
    }

    //关注事件引用
    public void setfollowOnClickListener(onfollowOnClickListener onfollowOnClickListener) {
        followOnClickListener = onfollowOnClickListener;
    }

    //删除事件引用
    public void setdeleteOnClickListener(ondeleteOnClickListener ondeleteOnClickListener) {
        deleteOnClickListener = ondeleteOnClickListener;
    }

    //自定义关注事件
    public interface onfollowOnClickListener {
        public void onfollowClick();
    }

    //自定义删除事件
    public interface ondeleteOnClickListener {
        public void ondeleteClick();
    }
}
