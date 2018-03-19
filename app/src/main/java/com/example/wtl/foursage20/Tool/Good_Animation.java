package com.example.wtl.foursage20.Tool;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * 点赞动画
 * Created by WTL on 2018/3/10.
 */

public class Good_Animation extends Animation{

    //放大动画
    public static void Enlarge(View view) {
        /*float fromX 动画起始时 X坐标上的伸缩尺寸
        float toX 动画结束时 X坐标上的伸缩尺寸
        float fromY 动画起始时Y坐标上的伸缩尺寸
        float toY 动画结束时Y坐标上的伸缩尺寸
        int pivotXType 动画在X轴相对于物件位置类型
        float pivotXValue 动画相对于物件的X坐标的开始位置
        int pivotYType 动画在Y轴相对于物件位置类型
        float pivotYValue 动画相对于物件的Y坐标的开始位置*/
        ScaleAnimation animation = new ScaleAnimation(0.0f, 1.6f, 0.0f, 1.6f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(200);//设置动画时长
        animation.setRepeatCount(1);//设置重复次数
        animation.setRepeatMode(Animation.REVERSE);//设置动画效果
        view.startAnimation(animation);//将动画加载到view上
    }

}
