package test.mysloopview;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * @author xiong
 * @ClassName: SloopAnimation
 * @Description: todo(自定义动画)
 * @date 2017/2/7
 */

public class SloopAnimation extends Animation
{
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t)
    {
        //透明度变化
//        t.setAlpha(interpolatedTime);

        //平移动画
//        t.getMatrix().setTranslate(200 * interpolatedTime, 200 * interpolatedTime);

        //左右晃动动画，利用正弦函数
        t.getMatrix().setTranslate((float) (Math.sin(interpolatedTime * 30))*80, 0);
        super.applyTransformation(interpolatedTime, t);
    }
}
