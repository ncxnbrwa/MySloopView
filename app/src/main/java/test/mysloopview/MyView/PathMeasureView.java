package test.mysloopview.MyView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import test.mysloopview.R;

/**
 * @author xiong
 * @ClassName: PathMeasureView
 * @Description: todo(PathMeasure测试View)
 * @date 2017/1/10
 */

public class PathMeasureView extends View
{
    Paint mPaint;
    int mHeight, mWidth;
    private final String TAG = "PathMeasureView";

    private float currentValue = 0;     // 用于纪录当前的位置,取值范围[0,1]映射Path的整个长度

    private float[] pos;                // 当前点的实际位置
    private float[] tan;                // 当前点的tangent值,用于计算图片所需旋转的角度
    private Bitmap mBitmap;             // 箭头图片
    private Matrix mMatrix;             // 矩阵,用于对图片进行一些操作

    public PathMeasureView(Context context)
    {
        this(context, null);
    }

    public PathMeasureView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initPaint();
        init(context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = h;
        mWidth = w;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.translate(mWidth / 2, mHeight / 2);
        Path path = new Path();
        Path dst = new Path();
//        path.lineTo(0, 200);
//        path.lineTo(200, 200);
//        path.lineTo(200, 0);
//
//        PathMeasure pathMeasure1 = new PathMeasure(path, true);
//        PathMeasure pathMeasure2 = new PathMeasure(path, false);
//        Logger.t(TAG).d("pathMeasure1:" + pathMeasure1.getLength());
//        Logger.t(TAG).d("pathMeasure2:" + pathMeasure2.getLength());
//
//        canvas.drawPath(path, mPaint);

        //截取path一段
//        path.addRect(-200, -200, 200, 200, Path.Direction.CCW);
//        PathMeasure pathMeasure = new PathMeasure(path, false);
        //startD开始截取位置距离 Path 起点的长度
        //stopD结束截取位置距离 Path 起点的长度
        // 取值范围: 0 <= startD < stopD <= Path总长度
        //dst 截取的 Path 将会添加到 dst 中(注意: 是添加，而不是替换)
        //startWithMoveTo 用于保证截取的Path第一个点位置不变
        //设为false时，会把截到dst路径中的一段与dst中原有的路径连起来
        // 截取一部分存入dst中，并使用 moveTo 保持截取得到的 Path
        // 第一个点的位置不变
//        pathMeasure.getSegment(400, 800, dst, true);
//        canvas.drawPath(dst, mPaint);

        //nextContour方法，用于跳到下一条路径
//        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
//        path.addRect(-100, -100, 100, 100, Path.Direction.CW);
//        canvas.drawPath(path, mPaint);
//        PathMeasure pathMeasure = new PathMeasure(path, false);
//        //getLength()并不会获得所有路径的总长度，而是得到按顺序画的其中一条路径长度
//        Logger.t(TAG).d("length1:" + pathMeasure.getLength());
//        pathMeasure.nextContour();
//        Logger.t(TAG).d("length2:" + pathMeasure.getLength());

        //绘制一个带箭头转动的圆
        // 添加一个圆形
        path.addCircle(0, 0, 200, Path.Direction.CW);
        // 创建 PathMeasure
        PathMeasure measure = new PathMeasure(path, false);
        // 计算当前的位置在总长度上的比例[0,1]
        currentValue += 0.005;
        if (currentValue >= 1) {
            currentValue = 0;
        }
        // 获取当前位置的坐标以及趋势
        //distance,距离 Path 起点的长度,取值范围: 0 <= distance <= getLength
        //pos该点的坐标值,当前点在画布上的位置，有两个数值，分别为x，y坐标。
        //tan该点的正切值,当前点在曲线上的方向，使用 Math.atan2(tan[1], tan[0]) 获取到正切角的弧度值。
        measure.getPosTan(measure.getLength() * currentValue, pos, tan);
        // 重置Matrix
        mMatrix.reset();
        // 计算图片旋转角度
        // atan2()方法是根据正切数值计算出该角度的大小,得到的单位是弧度
        float degrees = (float) (Math.atan2(tan[1], tan[0])
                * 180.0 / Math.PI);

        // 旋转图片
        mMatrix.postRotate(degrees, mBitmap.getWidth() / 2
                , mBitmap.getHeight() / 2);
        // 将图片绘制中心调整到与当前点重合
        mMatrix.postTranslate(pos[0] - mBitmap.getWidth() / 2
                , pos[1] - mBitmap.getHeight() / 2);

        // 绘制 Path
        canvas.drawPath(path, mPaint);
        // 绘制箭头
        canvas.drawBitmap(mBitmap, mMatrix, mPaint);
        // 重绘页面
        invalidate();
    }

    private void initPaint()
    {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10f);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    private void init(Context context) {
        pos = new float[2];
        tan = new float[2];
        BitmapFactory.Options options = new BitmapFactory.Options();
        // 缩放图片
        options.inSampleSize = 4;
        mBitmap = BitmapFactory.decodeResource(context.getResources()
                , R.mipmap.arrow, options);
        mMatrix = new Matrix();
    }
}
