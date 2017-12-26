package test.mysloopview.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author xiong
 * @ClassName: MatrixCameraView
 * @Description: todo(MatrixCamera测试View)
 * @date 2017/1/16
 */

public class MatrixCameraView extends View
{
    Paint mPaint;

    public MatrixCameraView(Context context)
    {
        this(context, null);
    }

    public MatrixCameraView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {

    }

    private void initPaint()
    {
        mPaint = new Paint();
        mPaint.setStrokeWidth(10f);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
    }
}
