package com.example.wtl.foursage20.Tool;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * 软键盘监听
 * Created by WTL on 2018/3/20.
 */

public class Soft_Keyboard_Tool {

    private View rooyview; //activity的根视图

    int rootviewVisibleHeight;  //activity根视图的高度

    private OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener;  //自定义接口

    public Soft_Keyboard_Tool(Activity activity) {
        rooyview = activity.getWindow().getDecorView(); //获取activity的根视图

        //监听视图中全局布局的改变
        rooyview.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //获取当前根视图在屏幕上的大小
                Rect rect = new Rect();
                rooyview.getWindowVisibleDisplayFrame(rect);
                int visibleHeight = rect.height();
                //根视图高度为0
                if(rootviewVisibleHeight == 0) {
                    rootviewVisibleHeight = visibleHeight;
                    return;
                }
                //根视图显示高度没有变化，可以看作软键盘显示／隐藏状态没有改变
                if(rootviewVisibleHeight == visibleHeight) {
                    return;
                }
                //根视图显示高度变小超过200，可以看作软键盘显示了
                if(rootviewVisibleHeight-visibleHeight > 200) {
                    if(onSoftKeyBoardChangeListener != null) {
                        onSoftKeyBoardChangeListener.keyBoardShow(rootviewVisibleHeight-visibleHeight);
                    }
                    rootviewVisibleHeight = visibleHeight;
                    return;
                }
                //根视图显示高度变大超过200，可以看作软键盘隐藏了
                if(visibleHeight-rootviewVisibleHeight > 200) {
                    if(onSoftKeyBoardChangeListener != null) {
                        onSoftKeyBoardChangeListener.keyBoardHide(visibleHeight-rootviewVisibleHeight);
                    }
                    rootviewVisibleHeight = visibleHeight;
                    return;
                }
            }
        });
    }

    private void setOnSoftKeyBoardChangeListener(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener){
        this.onSoftKeyBoardChangeListener = onSoftKeyBoardChangeListener;
    }

    /*
    * 自定义接口
    * */
    public interface OnSoftKeyBoardChangeListener {
        void keyBoardShow(int height);  //展示软键盘
        void keyBoardHide(int height);  //隐藏软键盘
    }

    public static void setListener(Activity activity,OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        Soft_Keyboard_Tool softKeyboardTool = new Soft_Keyboard_Tool(activity);
        softKeyboardTool.setOnSoftKeyBoardChangeListener(onSoftKeyBoardChangeListener);
    }

}
