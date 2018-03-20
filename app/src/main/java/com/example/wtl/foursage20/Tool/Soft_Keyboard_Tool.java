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

    private View rooyview;

    int rootviewVisibleHeight;

    private OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener;

    public Soft_Keyboard_Tool(Activity activity) {
        rooyview = activity.getWindow().getDecorView();
        rooyview.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();
                rooyview.getWindowVisibleDisplayFrame(rect);

                int visibleHeight = rect.height();
                if(rootviewVisibleHeight == 0) {
                    rootviewVisibleHeight = visibleHeight;
                    return;
                }

                if(rootviewVisibleHeight == visibleHeight) {
                    return;
                }

                if(rootviewVisibleHeight-visibleHeight > 200) {
                    if(onSoftKeyBoardChangeListener != null) {
                        onSoftKeyBoardChangeListener.keyBoardShow(rootviewVisibleHeight-visibleHeight);
                    }
                    rootviewVisibleHeight = visibleHeight;
                    return;
                }

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

    public interface OnSoftKeyBoardChangeListener {
        void keyBoardShow(int height);
        void keyBoardHide(int height);
    }

    public static void setListener(Activity activity,OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        Soft_Keyboard_Tool softKeyboardTool = new Soft_Keyboard_Tool(activity);
        softKeyboardTool.setOnSoftKeyBoardChangeListener(onSoftKeyBoardChangeListener);
    }

}
