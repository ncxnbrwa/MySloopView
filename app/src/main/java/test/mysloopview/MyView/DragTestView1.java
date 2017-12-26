package test.mysloopview.MyView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import test.mysloopview.R;
import test.mysloopview.SloopApplication;

/**
 * @author xiong
 * @ClassName: DragTestView1
 * @Description: todo(移动图片)
 * @date 2017/1/19
 */

public class DragTestView1 extends View
{
    Paint mPaint;
    int mWidth, mHeight;
    String TAG = "DragTest";
    Bitmap bmp;
    RectF bmpRectf;
    Matrix bmpMatrix;

    boolean canDrag = false;
    PointF lastPoint = new PointF(0, 0);

    public DragTestView1(Context context)
    {
        this(context, null);
    }

    public DragTestView1(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initPaint();
        //调整图片大小
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
//        options.outWidth = 960 / 2;
//        options.outHeight = 800 / 2;

        bmp = BitmapFactory.decodeResource(SloopApplication.getmContext()
                        .getResources()
                , R.mipmap.drag_test1, options);
        bmpMatrix = new Matrix();
        bmpRectf = new RectF(0, 0, bmp.getWidth(), bmp.getHeight());
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                // 判断按下位置是否包含在图片区域内且是不是第一个手指
                if (event.getPointerId(event.getActionIndex()) == 0
                        && bmpRectf.contains(event.getX(), event.getY()))
                {
                    canDrag = true;
                    lastPoint.set(event.getX(), event.getY());
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (canDrag)
                {
                    // 注意 getX 和 getY
                    int index = event.findPointerIndex(0);
                    // 移动图片
                    bmpMatrix.postTranslate(event.getX(index) - lastPoint.x
                            , event.getY(index) - lastPoint.y);
                    // 更新上一次点位置
                    lastPoint.set(event.getX(index), event.getY(index));
                    // 更新图片区域
                    bmpRectf = new RectF(0, 0, bmp.getWidth(), bmp.getHeight());
                    bmpMatrix.mapRect(bmpRectf);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                // 判断是否是第一个手指
                if (event.getPointerId(event.getActionIndex()) == 0)
                    canDrag = false;
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawBitmap(bmp, bmpMatrix, mPaint);
    }

    private void initPaint()
    {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(30f);
        mPaint.setTextAlign(Paint.Align.CENTER);
    }
}
