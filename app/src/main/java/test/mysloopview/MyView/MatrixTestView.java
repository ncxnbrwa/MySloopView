package test.mysloopview.MyView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import test.mysloopview.R;
import test.mysloopview.SloopApplication;

/**
 * @author xiong
 * @ClassName: MatrixTestView
 * @Description: todo(Matrix测试View)
 * @date 2017/1/12
 */

public class MatrixTestView extends View
{
    Paint mPaint;
    private static final String TAG = "MatrixTest";
    Matrix matrix;
    Bitmap bmp;

    public MatrixTestView(Context context)
    {
        this(context, null);
    }

    public MatrixTestView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        //pre:右乘， M‘ = M*A
        //post:左乘， M’ = A*M
        matrix = new Matrix();
//        float[] pts = new float[]{0, 0, 80, 100, 400, 300};
//        //x坐标缩放0.5
//        matrix.setScale(0.5f, 1.0f);
//        // 输出pts计算之前数据
//        Logger.t(TAG).d("before:" + Arrays.toString(pts));
//        // 调用map方法计算
//        //void mapPoints (float[] dst, float[] src)
//        //src作为参数传递原始数值，计算结果存放在dst中，src不变
//        //void mapPoints (float[] dst, int dstIndex,float[] src, int srcIndex, int pointCount)
//        //可以指定只计算一部分数值。
//        matrix.mapPoints(pts);
//        // 输出pts计算之后数据
//        Logger.t(TAG).d("after:" + Arrays.toString(pts));

        initPoly();
        canvas.drawBitmap(bmp, matrix, mPaint);
    }

    //自由变换
    private void initPoly()
    {
        bmp = BitmapFactory.decodeResource(SloopApplication.getmContext().getResources()
                , R.mipmap.poly_test);
        float[] src = new float[]
                {
                        0, 0,
                        bmp.getWidth(), 0,
                        bmp.getWidth(), bmp.getHeight(),
                        0, bmp.getHeight()};
        float[] dst = new float[]
                {
                        0, 0,
                        bmp.getWidth(), 400,
                        bmp.getWidth(), bmp.getHeight() - 200,
                        0, bmp.getHeight()
                };

        matrix.setPolyToPoly(src, 0, dst, 0, src.length >> 1);
        matrix.postScale(0.5f, 0.5f);
        matrix.postTranslate(100, 200);
    }

    private void initPaint()
    {
        mPaint = new Paint();
        mPaint.setStrokeWidth(10f);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
    }
}
