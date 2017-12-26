package test.mysloopview.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author xiong
 * @ClassName: CanvasTestView
 * @Description: todo(canvas操作测试View)
 * @date 2017/1/3
 */

public class CanvasTestView extends View
{
    Paint mPaint;
    int mWidth, mHeight;

    public CanvasTestView(Context context)
    {
        this(context, null);
    }

    public CanvasTestView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        //将坐标系原点移动到画布正中心
//        canvas.translate(mWidth / 2, mHeight / 2);
        //平移画布绘制圆形
        mPaint.setColor(Color.BLUE);
        canvas.translate(100f, 100f);
        canvas.drawCircle(0, 0, 100, mPaint);
        canvas.translate(300f, 300f);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(0, 0, 100, mPaint);


        //缩放图形
        //负值会绕旋转中心翻转
//        mPaint.setColor(Color.BLUE);
//        canvas.translate(mWidth / 2, mHeight / 2);
//        RectF mRect = new RectF(0, -150, 150, 0);
//        canvas.drawRect(mRect, mPaint);
        //放大图形
//        canvas.scale(2, 2);
//        canvas.scale(-2, -2);
//        canvas.scale(2,2,100,0);
        //缩放图形
//        canvas.scale(0.5f, 0.5f);
//        canvas.scale(-0.5f, -0.5f);
        //带偏移量的缩放
//        canvas.scale(0.5f,0.5f,-100,0);
//        mPaint.setColor(Color.BLACK);
//        canvas.drawRect(mRect, mPaint);
        //绘制缩放层次图
//        RectF mRect2 = new RectF(-150, -150, 150, 150);
//        for (int i = 0; i < 10; i++)
//        {
//            canvas.scale(0.9f, 0.9f);
//            canvas.drawRect(mRect2, mPaint);
//        }

        //旋转
        //调用两次旋转，则实际的旋转角度为180+20=200度
//        canvas.translate(mWidth / 2, mHeight / 2);
//        mPaint.setColor(Color.BLUE);
//        RectF mRectF = new RectF(0, -100, 100, 0);
//        canvas.drawRect(mRectF, mPaint);
        //旋转图形
//        canvas.rotate(180);
        //带偏移量的旋转
//        canvas.rotate(180, 20, 0);
//        mPaint.setColor(Color.BLACK);
//        canvas.drawRect(mRectF, mPaint);
        //画个带线的圆环
//        canvas.drawCircle(0, 0, 180, mPaint);
//        canvas.drawCircle(0, 0, 200, mPaint);
//        for (int i = 0; i <= 36; i++)
//        {
//            canvas.drawLine(0, 180, 0, 200, mPaint);
//            canvas.rotate(10);
//        }

        //错切
        //变换后：X = x + sx * y
        //      Y = sy * x + y
//        mPaint.setColor(Color.BLUE);
//        RectF skewRect = new RectF(0, -200, 200, 0);
//        canvas.drawRect(skewRect, mPaint);
        //float sx:将画布在x方向上倾斜相应的角度，sx倾斜角度的tan值，
        //float sy:将画布在y轴方向上倾斜相应的角度，sy为倾斜角度的tan值.
        //水平错切 <- 45度
//        canvas.skew(1, 0);
//        //竖直错切 45°
//        canvas.skew(0, 1);
//        mPaint.setColor(Color.BLACK);
//        canvas.drawRect(skewRect, mPaint);

        //快照(save)和回滚(restore)
        //save	把当前的画布的状态进行保存，然后放入特定的栈中
        //saveLayerXxx	新建一个图层，并放入特定的栈中
        //restore	把栈中最顶层的画布状态取出来，并按照这个状态恢复当前的画布
        //restoreToCount	弹出指定位置及其以上所有的状态，并按照指定位置的状态进行恢复
        //getSaveCount	获取栈中内容的数量(即保存次数)
    }

    private void initPaint()
    {
        mPaint = new Paint();
        mPaint.setStrokeWidth(10f);
        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setColor(Color.BLUE);
    }
}
