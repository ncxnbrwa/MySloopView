package test.mysloopview.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author xiong
 * @ClassName: SloopPaintView
 * @Description: todo(测试paint类的view)
 * @date 2016/12/28
 */

public class SloopPaintView extends View
{
    public SloopPaintView(Context context)
    {
        super(context);
    }

    public SloopPaintView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        Paint mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(50);
        //填充
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(500, 200, 50, mPaint);
        //描边
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(500, 400, 50, mPaint);
        // 描边加填充
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(500, 600, 50, mPaint);
    }

}
