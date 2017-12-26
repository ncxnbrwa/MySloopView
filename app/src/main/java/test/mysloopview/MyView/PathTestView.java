package test.mysloopview.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author xiong
 * @ClassName: PathTestView
 * @Description: todo(path测试View)
 * @date 2017/1/4
 */

public class PathTestView extends View
{
    Paint mPaint;
    int mWidth, mHeight;

    public PathTestView(Context context)
    {
        this(context, null);
    }

    public PathTestView(Context context, AttributeSet attrs)
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
//        canvas.translate(mWidth / 2, mHeight / 2);
        Path path = new Path();
        Path src = new Path();
        //简单的连线
//        path.lineTo(100, 100);
//        path.lineTo(100, 0);
//        canvas.drawPath(path, mPaint);

        //加上MoveTo画线
//        path.lineTo(100, 100);
//        path.moveTo(100, 50);
//        path.lineTo(100, 0);
//        canvas.drawPath(path, mPaint);

        //setLastPoint重置上一点的位置
//        path.lineTo(100, 100);
//        path.setLastPoint(100, 50);
//        path.lineTo(100, 0);
//        canvas.drawPath(path, mPaint);

        //close封闭路径
//        path.lineTo(100, 100);
//        path.lineTo(100, 0);
//        path.close();
//        canvas.drawPath(path, mPaint);

        //添加矩形
        //交换坐标点的顺序可能就会影响到某些绘制内容
        //参数中点的顺序很重要！
//        path.addRect(50, 50, -50, -50, Path.Direction.CW);
//        //重置位置
//        path.setLastPoint(-100, 100);
//        canvas.drawPath(path, mPaint);

        //合并路径
//        canvas.scale(1, -1);
//        path.addRect(50, 50, -50, -50, Path.Direction.CW);
//        src.addCircle(0, 0, 25, Path.Direction.CW);
////        path.addPath(src);
//        //添加路径带位移
//        path.addPath(src, 0, 50);
//        canvas.drawPath(path, mPaint);

        //添加圆弧
        //翻转Y坐标轴
//        canvas.scale(1, -1);
//        path.lineTo(100, 100);
////        path.addArc(new RectF(0, 0, 300, 300), 0, 270);
//        //或者
////        path.arcTo(new RectF(0, 0, 300, 300), 0, 270, true);
//        //false代表把首尾亮点连起来
//        path.arcTo(new RectF(0, 0, 300, 300), 0, 270, false);
//        canvas.drawPath(path, mPaint);

//        path.lineTo(0, 400);
//        path.lineTo(400, 400);
//        path.lineTo(400, 0);
//        path.lineTo(0, 0);
//
//        RectF rect = new RectF();
//        //判断路径是否为矩形
//        boolean b = path.isRect(rect);
//        Logger.t("Rect").d("isRect:" + b + "| left:" + rect.left + "| top:" + rect.top
//                + "| right:" + rect.right + "| bottom:" + rect.bottom);

//        path.addCircle(0, 0, 100, Path.Direction.CW);
//        src.addRect(new RectF(0, 0, 200, 200), Path.Direction.CW);
//        //第三个参数相当于把path的东西存入src覆盖了
//        path.offset(200, 0, src);
//        mPaint.setColor(Color.BLACK);
//        canvas.drawPath(path, mPaint);
//        mPaint.setColor(Color.BLUE);
//        canvas.drawPath(src, mPaint);

        //rXxx方法
//        path.moveTo(100, 100);
//        //相对于当前坐标移动，实际让点移到了（200,300）处
//        path.rLineTo(100, 200);
//        canvas.drawPath(path, mPaint);

        //path填充模式为奇偶规则
//        path.setFillType(Path.FillType.EVEN_ODD);
        //path填充模式为反奇偶规则
//        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        //path填充模式为非零环绕规则
//        path.setFillType(Path.FillType.WINDING);
        //顺时针方向
//        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
//        //逆时针方向
////        path.addRect(-200, -200, 200, 200, Path.Direction.CCW);
//        //添加大正方形
//        path.addRect(-400, -400, 400, 400, Path.Direction.CCW);
//        canvas.drawPath(path, mPaint);

        //布尔操作画出太极的阴阳鱼(API必须高于19)
//        if (Build.VERSION.SDK_INT >= 19)
//        {
//            Path path1 = new Path();
//            Path path2 = new Path();
//            Path path3 = new Path();
//            Path path4 = new Path();
//
//            path1.addCircle(0, 0, 200, Path.Direction.CW);
//            path2.addRect(0, -200, 200, 200, Path.Direction.CW);
//            path3.addCircle(0, -100, 100, Path.Direction.CW);
//            path4.addCircle(0, 100, 100, Path.Direction.CCW);
//
//            path1.op(path2, Path.Op.DIFFERENCE);
//            path1.op(path3, Path.Op.UNION);
//            path1.op(path4, Path.Op.DIFFERENCE);
//            canvas.drawPath(path1, mPaint);
//        }

        //布尔操作示例
        // 对 path1 和 path2 执行布尔运算，运算方式由第二个参数指定，运算结果存入到path1中。
//        path1.op(path2, Path.Op.DIFFERENCE);

        // 对 path1 和 path2 执行布尔运算，运算方式由第三个参数指定，运算结果存入到path3中。
//        path3.op(path1, path2, Path.Op.DIFFERENCE);
        int x = 20;
        int r = 50;
        canvas.translate(150, 0);

        if (Build.VERSION.SDK_INT >= 19)
        {
            Path path1 = new Path();
            Path path2 = new Path();
            Path pathResult = new Path();

            path1.addCircle(-x, 0, r, Path.Direction.CW);
            path2.addCircle(x, 0, r, Path.Direction.CW);

            //path1和path2相交，去掉path2的部分
            pathResult.op(path1, path2, Path.Op.DIFFERENCE);
            canvas.translate(0, 100);
            canvas.drawText("DIFFERENCE", 120, 0, mPaint);
            canvas.drawPath(pathResult, mPaint);

            //path1和path2相交，去掉path1的部分
            pathResult.op(path1, path2, Path.Op.REVERSE_DIFFERENCE);
            canvas.translate(0, 150);
            canvas.drawText("REVERSE_DIFFERENCE", 120, 0, mPaint);
            canvas.drawPath(pathResult, mPaint);

            //path1和path2取交集部分
            pathResult.op(path1, path2, Path.Op.INTERSECT);
            canvas.translate(0, 150);
            canvas.drawText("INTERSECT", 120, 0, mPaint);
            canvas.drawPath(pathResult, mPaint);

            //path1和path2取合集部分
            pathResult.op(path1, path2, Path.Op.UNION);
            canvas.translate(0, 150);
            canvas.drawText("UNION", 120, 0, mPaint);
            canvas.drawPath(pathResult, mPaint);

            //异或 ,取path1和path2交集以外的部分
            pathResult.op(path1, path2, Path.Op.XOR);
            canvas.translate(0, 150);
            canvas.drawText("XOR", 120, 0, mPaint);
            canvas.drawPath(pathResult, mPaint);

            //void computeBounds (RectF bounds, boolean exact);
            //bounds 测量结果会放入该参数
            //exact 是否精准测量，true即可
        }
    }

    private void initPaint()
    {
        mPaint = new Paint();
        mPaint.setStrokeWidth(10f);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(30);
    }
}
