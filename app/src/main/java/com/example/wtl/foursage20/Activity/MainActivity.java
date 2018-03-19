package com.example.wtl.foursage20.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wtl.foursage20.LoadFragment.Public_Comment_Fragment;
import com.example.wtl.foursage20.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Public_Comment_Fragment publicCommentFragment;//大众点评碎片

    private LinearLayout Public_Comment;//大众点评
    private ImageView Public_Comment_img;//大众点评图片
    private TextView Public_Comment_text;//大众点评文字

    private LinearLayout News;//消息
    private ImageView News_img;//消息图片
    private TextView News_text;//消息文字

    private LinearLayout Mine;//我的
    private ImageView Mine_img;//我的图片
    private TextView Mine_text;//我的文字

    private ArrayList<MyTouchListener> arrayList = new ArrayList<MyTouchListener>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Monitor();
        change_fragment(0);
    }

    /*监听控件*/
    private void Monitor() {
        Public_Comment = (LinearLayout) findViewById(R.id.Public_Comment);
        Public_Comment_img = (ImageView) findViewById(R.id.Public_Comment_img);
        Public_Comment_text = (TextView) findViewById(R.id.Public_Comment_tex);

        News = (LinearLayout) findViewById(R.id.News);
        News_img = (ImageView) findViewById(R.id.News_img);
        News_text = (TextView) findViewById(R.id.News_text);

        Mine = (LinearLayout) findViewById(R.id.Mine);
        Mine_img = (ImageView) findViewById(R.id.Mine_img);
        Mine_text = (TextView) findViewById(R.id.Mine_text);

        Public_Comment.setOnClickListener(this);
        Public_Comment_img.setOnClickListener(this);
        Public_Comment_text.setOnClickListener(this);

        News.setOnClickListener(this);
        News_img.setOnClickListener(this);
        News_text.setOnClickListener(this);

        Mine.setOnClickListener(this);
        Mine_img.setOnClickListener(this);
        Mine_text.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Public_Comment_img:
                change_fragment(0);

                Public_Comment_text.setTextColor(0xffd4237a);
                News_text.setTextColor(0xffb7b7b7);
                Mine_text.setTextColor(0xffb7b7b7);

                Public_Comment_img.setImageResource(R.mipmap.touchpublicommend);
                News_img.setImageResource(R.mipmap.news);
                Mine_img.setImageResource(R.mipmap.mine);
                break;
            case R.id.Public_Comment_tex:
                change_fragment(0);

                Public_Comment_text.setTextColor(0xffd4237a);
                News_text.setTextColor(0xffb7b7b7);
                Mine_text.setTextColor(0xffb7b7b7);

                Public_Comment_img.setImageResource(R.mipmap.touchpublicommend);
                News_img.setImageResource(R.mipmap.news);
                Mine_img.setImageResource(R.mipmap.mine);
                break;
            case R.id.News_img:

                Public_Comment_text.setTextColor(0xffb7b7b7);
                News_text.setTextColor(0xffd4237a);
                Mine_text.setTextColor(0xffb7b7b7);

                Public_Comment_img.setImageResource(R.mipmap.publicommend);
                News_img.setImageResource(R.mipmap.touchnews);
                Mine_img.setImageResource(R.mipmap.mine);
                break;
            case R.id.News_text:

                Public_Comment_text.setTextColor(0xffb7b7b7);
                News_text.setTextColor(0xffd4237a);
                Mine_text.setTextColor(0xffb7b7b7);

                Public_Comment_img.setImageResource(R.mipmap.publicommend);
                News_img.setImageResource(R.mipmap.touchnews);
                Mine_img.setImageResource(R.mipmap.mine);
                break;
            case R.id.Mine_img:

                Public_Comment_text.setTextColor(0xffb7b7b7);
                News_text.setTextColor(0xffb7b7b7);
                Mine_text.setTextColor(0xffd4237a);

                Public_Comment_img.setImageResource(R.mipmap.publicommend);
                News_img.setImageResource(R.mipmap.news);
                Mine_img.setImageResource(R.mipmap.touchmine);
                break;
            case R.id.Mine_text:

                Public_Comment_text.setTextColor(0xffb7b7b7);
                News_text.setTextColor(0xffb7b7b7);
                Mine_text.setTextColor(0xffd4237a);

                Public_Comment_img.setImageResource(R.mipmap.publicommend);
                News_img.setImageResource(R.mipmap.news);
                Mine_img.setImageResource(R.mipmap.touchmine);
                break;
        }
    }

    private void change_fragment(int x) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hide_fragment(transaction);
        switch (x) {
            case 0:
                if(publicCommentFragment == null) {
                    publicCommentFragment = new Public_Comment_Fragment();
                    transaction.add(R.id.main,publicCommentFragment);
                } else {
                    transaction.show(publicCommentFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hide_fragment(FragmentTransaction transaction) {
        if(publicCommentFragment != null) {
            transaction.hide(publicCommentFragment);
        }
    }

    //注册手势滑动接口
    public interface MyTouchListener {
        boolean onTouchEvent(MotionEvent event);
    }

    //添加手势监听
    public void registerMytTouchListener(MyTouchListener listener) {
        arrayList.add(listener);
    }

    //注销手势监听
    public void dispathMyTouchListener(MyTouchListener listener) {
        arrayList.remove(listener);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        for(MyTouchListener listener : arrayList) {
            listener.onTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }
}
