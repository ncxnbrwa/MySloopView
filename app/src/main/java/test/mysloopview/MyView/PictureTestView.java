package test.mysloopview.MyView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import test.mysloopview.R;

/**
 * @author xiong
 * @ClassName: PictureTextTestView
 * @Description: todo(图片文字测试View)
 * @date 2017/1/3
 */

public class PictureTestView extends View
{
    Paint mPaint;
    Picture mPicture = new Picture();
    int mWidth, mHeight;

    public PictureTestView(Context context)
    {
        this(context, null);
    }

    public PictureTestView(Context context, AttributeSet attrs)
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
        recording();
        //图片出不来，需关闭硬件加速
        //该方法不会压缩图片，但可操作性低，且会影响canvas状态
//        mPicture.draw(canvas);

        //绘制内容有一定缩放
//        canvas.drawPicture(mPicture,
//                new RectF(0, 0, mPicture.getWidth(), 200));

        //包装成drawable
//        PictureDrawable drawable = new PictureDrawable(mPicture);
//        //设置绘制区域
//        drawable.setBounds(0,0,mPicture.getWidth(),mPicture.getHeight());
//        drawable.draw(canvas);

        //Bitmap绘制
        //资源文件
        Bitmap bmp = BitmapFactory.decodeResource(getResources()
                , R.mipmap.bmp01);
        //assets文件
//        Bitmap bmp02 = null;
//        try
//        {
//            InputStream is = SloopApplication.getmContext()
//                    .getAssets().open("bmp02.jpg");
//            bmp02 = BitmapFactory.decodeStream(is);
//            is.close();
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
        //内存卡文件
//        Bitmap bitmap = BitmapFactory.decodeFile("/sdcard/bitmap.png");
//        canvas.drawBitmap(bmp, new Matrix(), mPaint);
        //第二个参数和第三个参数分别代表距离坐标原点的横向，纵向距离
//        canvas.drawBitmap(bmp, 100, 200, mPaint);
        canvas.translate(mWidth / 2, mHeight / 2);
        //该参数指定截取图片的哪一块
        Rect src = new Rect(0, 0, bmp.getWidth() / 2, bmp.getHeight() / 2);
        //该参数指定画在哪一个区域
        Rect dst = new Rect(0, 0, 200, 400);
        canvas.drawBitmap(bmp, src, dst, mPaint);
    }

    private void initPaint()
    {
        mPaint = new Paint();
        mPaint.setStrokeWidth(10f);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
    }

    private void recording()
    {
        Canvas canvas = mPicture.beginRecording(500, 500);
        canvas.translate(250, 250);
        canvas.drawCircle(0, 0, 100, mPaint);
        mPicture.endRecording();
    }
}
