package test.mysloopview.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import test.mysloopview.R;

/**
 * @author xiong
 * @ClassName: SloopView
 * @Description: todo(自定义类)
 * @date 2016/12/22
 */

public class SloopView extends View
{
    Paint mPaint;

    public SloopView(Context context)
    {
        super(context);
//        initPaints();
    }

    public SloopView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        //这里初始化xmls才有效
        initPaints();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawColor(getResources().getColor(R.color.dark_white));
        canvas.drawPoint(200, 150, mPaint);
        canvas.drawPoint(400, 450, mPaint);
        canvas.drawPoint(400, 550, mPaint);
        canvas.drawPoint(400, 650, mPaint);
        canvas.drawPoint(600, 150, mPaint);
        // 在坐标(200,850)(600,850)之间绘制一条直线
        canvas.drawLine(200, 850, 600, 850, mPaint);
        // 绘制一组线 每四数字(两个点的坐标)确定一条线
        canvas.drawLines(new float[]
                {
                        300, 150, 400, 600,
                        300, 400, 400, 750
                }, mPaint);
        //绘制矩形，取左上角顶点和右下角顶点坐标
//        canvas.drawRect(600,900,650,950,mPaint);
        //RectF是float(单精度浮点型)的
//        canvas.drawRect(new RectF(500,900,650,950),mPaint);
        //Rect是int(整形)的
        canvas.drawRect(new Rect(400, 900, 650, 950), mPaint);

        //绘制圆角矩形
        //这里圆角矩形的角实际上不是一个正圆的圆弧，
        //而是椭圆的圆弧，这里的两个参数实际上是椭圆的两个半径
        //改变rx,ry大于矩形宽高会出现圆或椭圆
        canvas.drawRoundRect(new RectF(10, 10, 100, 100), 20, 20, mPaint);
        //该方法在API21的时候才添加上
//        canvas.drawRoundRect(10,10,100,100,20,20,mPaint);

        //绘制椭圆
        //如果你传递进来的是一个正方形，那么绘制出来的实际上就是一个圆。
        canvas.drawOval(new RectF(500, 10, 600, 80), mPaint);

        //绘制圆形
        //参数，前两个是圆心坐标，第三个是半径，最后一个是画笔
        canvas.drawCircle(80, 900, 50, mPaint);

        // 绘制圆弧
        // startAngle  开始角度
        // sweepAngle  扫过角度
        // useCenter   是否使用中心
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(10, 200, 120, 450, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(new RectF(10, 200, 120, 450), 0, 90, false, mPaint);
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(10, 500, 120, 650, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(new RectF(10, 500, 120, 650), 0, 90, true, mPaint);
    }

    /**
     * @return 返回类型
     * @throws
     * @Description: todo(初始化paint参数)
     */
    private void initPaints()
    {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10f);
        //STROKE  描边
        //FILL   填充
        //FILL_AND_STROKE  描边加填充
        mPaint.setStyle(Paint.Style.FILL);
    }
}
