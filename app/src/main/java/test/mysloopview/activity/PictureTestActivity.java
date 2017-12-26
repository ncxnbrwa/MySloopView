package test.mysloopview.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import test.mysloopview.MyView.CheckView;
import test.mysloopview.R;

@ContentView(R.layout.activity_picture_test)
public class PictureTestActivity extends BaseActivity
{
    @ViewInject(R.id.picture_toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.check_view)
    private CheckView checkView;
//    PictureTextTestView view;
//    Canvas canvas = new Canvas();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        view = new PictureTextTestView(this);
//        Bitmap bmp02 = null;
//        try
//        {
//            InputStream is = getAssets().open("bmp02.jpg");
//            bmp02 = BitmapFactory.decodeStream(is);
//            is.close();
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        canvas.drawBitmap(bmp02, new Matrix(), new Paint());
    }

    @Event(value = {R.id.btn_check, R.id.btn_uncheck})
    private void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_check:
                checkView.check();
                break;
            case R.id.btn_uncheck:
                checkView.unCheck();
                break;
        }
    }
}
