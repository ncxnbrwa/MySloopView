package test.mysloopview.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author xiong
 * @ClassName: BezierTestView
 * @Description: todo()
 * @date 2017/1/5
 */

public class BezierErJieTestView extends View
{
    Paint mPaint;
    int centerX, centerY;
    PointF start, end, control;

    public BezierErJieTestView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initPaint();
        //初始化点坐标
        start = new PointF();
        end = new PointF();
        control = new PointF();
    }

    public BezierErJieTestView(Context context)
    {
        this(context, null);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;
        //开始点
        start.x = centerX - 200;
        start.y = centerY;
        //结束点
        end.x = centerX + 200;
        end.y = centerY;
        //控制点
        control.x = centerX;
        control.y = centerY - 100;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        //画出辅助点
        mPaint.setColor(Color.BLACK);
        canvas.drawPoint(start.x, start.y, mPaint);
        canvas.drawPoint(end.x, end.y, mPaint);
        canvas.drawPoint(control.x, control.y, mPaint);
        //画出辅助线
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(4f);
        canvas.drawLine(start.x, start.y, control.x, control.y, mPaint);
        canvas.drawLine(control.x, control.y, end.x, end.y, mPaint);
        //绘制贝塞尔曲线
        mPaint.setStrokeWidth(8f);
        mPaint.setColor(Color.RED);
        Path path = new Path();
        path.moveTo(start.x, start.y);
        path.quadTo(control.x, control.y, end.x, end.y);
        canvas.drawPath(path, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        //根据触摸位置更新控制点，并提示重绘
        control.x = event.getX();
        control.y = event.getY();
        invalidate();
        return true;
    }

    private void initPaint()
    {
        mPaint = new Paint();
        mPaint.setStrokeWidth(40f);
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(60);
    }
}
