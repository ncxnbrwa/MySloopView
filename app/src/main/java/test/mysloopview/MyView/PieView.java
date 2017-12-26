package test.mysloopview.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.orhanobut.logger.Logger;

import java.util.List;

import test.mysloopview.bean.PieDatas;

/**
 * @author xiong
 * @ClassName: PieView
 * @Description: todo(自定义饼状图)
 * @date 2016/12/29
 */

public class PieView extends View
{
    private static final String TAG = "MyPieView";
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    Paint mPaint = new Paint();
    int vWidth, vHeight;
    float vStartAngle;
    private List<PieDatas> data;

    public PieView(Context context)
    {
        this(context, null);
    }

    public PieView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
//        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.PieView);
//        int color = ta.getColor(R.styleable.PieView_pie_color, Color.RED);
//        setBackgroundColor(color);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10f);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        vWidth = w;
        vHeight = h;
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event)
    {
        return super.dispatchTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (data == null)
            return;
        canvas.translate(vWidth / 2, vHeight / 2);
        float rStartAngle = vStartAngle;
        float radius = (float) (Math.min(vWidth, vHeight) / 2 * 0.8);
        RectF rectF = new RectF(-radius, -radius, radius, radius);
        for (int i = 0; i < data.size(); i++)
        {
            PieDatas pie = data.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rectF, rStartAngle, pie.getAngle(),
                    true, mPaint);
            rStartAngle += data.get(i).getAngle();
        }
    }

    public void setvStartAngle(float vStartAngle)
    {
        this.vStartAngle = vStartAngle;
    }

    public void setData(List<PieDatas> data)
    {
        this.data = data;
        initData(data);
    }

    private void initData(List<PieDatas> data)
    {
        if (data == null || data.size() == 0)
            return;
        float sumValues = 0;
        for (int i = 0; i < data.size(); i++)
        {
            PieDatas pie = data.get(i);
            pie.setColor(mColors[i % mColors.length]);
            sumValues += pie.getValue();
        }

        float sumAngles = 0;
        for (int i = 0; i < data.size(); i++)
        {
            PieDatas pie = data.get(i);
            float percent = pie.getValue() / sumValues;
            pie.setPercentage(percent);
            float angle = percent * 360;
            pie.setAngle(angle);
            sumAngles += angle;
//            Log.i(TAG, sumAngles + "");
//            Log.i(TAG, pie.getAngle() + "");
            Logger.t(TAG).d(pie.getAngle() + "");
        }
    }
}
