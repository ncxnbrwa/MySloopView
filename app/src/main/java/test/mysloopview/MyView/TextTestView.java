package test.mysloopview.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author xiong
 * @ClassName: TextTestView
 * @Description: todo(画文字View)
 * @date 2017/1/4
 */

public class TextTestView extends View
{
    Paint mPaint;

    public TextTestView(Context context)
    {
        this(context, null);
    }

    public TextTestView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initPaint();
    }

    private void initPaint()
    {
        mPaint = new Paint();
//        mPaint.setStrokeWidth(10f);
//        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(50);
        mPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        String text = "ABCDEF";
        //参数分别为 (文本 基线x 基线y 画笔)
//        canvas.drawText(text, 200, 100, mPaint);
        // 参数分别为 (文本 开始截取位置 结束截取位置 基线x 基线y 画笔)
        //截取字符串是截前不截后，故结果写出"BC"
//        canvas.drawText(text, 1, 3, 200, 100, mPaint);
//        char[] chars = text.toCharArray();
//        canvas.drawText(chars, 1, 3, 200, 100, mPaint);

        //指定字符串中的每一个字母
        canvas.drawPosText(text, new float[]{
                100, 100,
                200, 200,
                300, 300,
                400, 400,
                500, 500,
                600, 600,
                700, 700
        }, mPaint);

    }
}
