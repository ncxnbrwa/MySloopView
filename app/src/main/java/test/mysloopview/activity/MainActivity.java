package test.mysloopview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.alipay.sdk.app.PayTask;
import com.orhanobut.logger.Logger;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.Map;

import test.mysloopview.MyView.SloopView;
import test.mysloopview.R;
import test.mysloopview.alipay.PayResult;
import test.mysloopview.alipay.util.OrderInfoUtil2_0;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity
{
    @ViewInject(R.id.toolBar)
    private Toolbar toolbar;
    @ViewInject(R.id.sloopView)
    private SloopView sloopView;

    private static final String TAG = "MyMainActivity";
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    public static final String RSA_PRIVATE = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCL8wk4vfQ5vZLC9TVPCezRTS9YOlAxcn785z21Q/kB4TP0dqxo0A4VuS+PwqHzysSkD4i2cDyWe5XmeSGMcqAJdFG7PYGjANwhSvC1WNS9gimVcnyk8l6yRkQGxH+g7Hej/eE1/Ks4U84m6WaWwilQTjBwWXIVka2ufK5TZTc9XYoCCHzV0S6AkH84W2iMNkYr8FwyCfTBMdY2D0P4jD2xzJm+iMXEsj9TLl1ZoRewKFQtxPoe4dUVQzODo6JnkW6Ry3fAgVVeXQZgQlTYWOVT+nmbAWTE2pqDhr/gfM1Mws+zxzVExItg/nRN3UqqrtHgia0fTEjDUqPam/E4RKrfAgMBAAECggEAR5X6ypaHvZ1V2/m32gU2qN01cYjqilCJ2m2iZ/0r+yUqAUtO55I9EimWxY+GbgDzUwRLJx8ELulqhOjDG2dqq0tfn0pX7Hw9HZ6KwAh/Uayp/rMARRNhEwnUNC4BJtyuWik8MPRc1MQxeD/9ZPJOVbCZIG7wZ04MLGvEdA4bEnzmPp0VCOopmDpJ3alWKPwbo1q4il617PF3ZjG+bOeusdExmxWEIwiKf1LfFN+v/CpaNMWzEi9FPAdVOJMqxiz5Hh521t1gdOnr1yssp8iUrhbcdPHtMphKWg3458e7rdN3MJseQ56Qy2umHcZtBinqwLhO/6yD8rDRZJI3+eidIQKBgQDwExv5xu48aRN/LuJc2jB8TZ0NCDOSM1GEz8v6VOkdjr1Pjk3s+bnx+Fte+pqYf7xRLMKdIAeoBXyKYkVAWn4H8Gudli21/MjaBr4VC1s5+AwlgO4qdXa0qCZLp+zDrc666rX/hAakYZ3wvIXnguCtvvX7FA6MwjLz2DIXKxZILwKBgQCVO590SA1c4NWbNkhVYMSHjJTBWCqdJPpFoGIuLk0C4KVAyxcqziBUMrrAjDKD1VKtr/5qluakr5TsAw5nHIqueWxWmbJIZBqGYFIWCWrG3lQasRexrj9pLhXzvtybEem17HXUgtdcAzMUe7fYmeFkvTeKLmdNkhkJFENYF3xsUQKBgQC+z+FnaGaIG1gEuUXvWPg6hBG0fvVGWYWMUwCj6gMSnBX5eniTRnU1ThmJZxOi67vIpRPVgNS1Bg9TigHSwVn0g3F1YhzYzZ7yM3O3FDyg2XcGA/DITG5Z7l/puAFmEeoDBHQ9Lzl8Q54d7ilbtdlQHzwxIGLkG6IVz5sYcQWXvwKBgF4TQgfpzBK64a2A4MSBxiK1KqlfzS1XPDZcTshSA9ZGi6Z24NnpK1QozrXHK6kT95Tql3XWPvuefED0BEZYJcyrWvKU3WDpShdf7R9bPGa1jUtuTEOEVxEVLl2D+kn/VteKgxU+jkjA85h8DX+MMhxxc+u2KQUrjoC8t193HsahAoGBANOXvtSjdQLEtI6ukNhVqxpbT6/ZlVo+pK0Z2Ij7NKoHIKrR1XK5gSOk2DzDk95vrDQHxSdsPBl/Ys/OvyIkj87iyTjtlo244kLX+mhQgTwDdboiQF3L8/8w7f7Sv8EMePuxWqcslk1/e6/N1k/HtD/9oFFGIEAJpvOgpbYcwzB0";
    public static final String APPID = "2016122604629932";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        Logger.t(TAG).d("onCreate");
        Logger.d("hello %s", "world");
        Logger.d("hello %s %d", "world", 5);   // String.format
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.setting:
                showToast("setting");
                break;
            case R.id.back:
                new AlipayThread().start();
                break;
            case R.id.paint_test:
                Intent paintTestIntent = new Intent(this, TestPaintActivity.class);
                startActivity(paintTestIntent);
                break;
            case R.id.pie_chart:
                Intent pieIntent = new Intent(this, PieChartActivity.class);
                startActivity(pieIntent);
                break;
            case R.id.canvas_test:
                Intent canvasIntent = new Intent(this, CanvasTestActivity.class);
                startActivity(canvasIntent);
                break;
            case R.id.picture_test:
                Intent pictureTextIntent = new Intent(this, PictureTestActivity.class);
                startActivity(pictureTextIntent);
                break;
            case R.id.text_test:
                Intent textIntent = new Intent(this, DrawTextTestActivity.class);
                startActivity(textIntent);
                break;
            case R.id.path_test:
                Intent pathIntent = new Intent(this, DrawPathActivity.class);
                startActivity(pathIntent);
                break;
            case R.id.bezier_test:
                Intent bezierIntent = new Intent(this, BezierTestActivity.class);
                startActivity(bezierIntent);
                break;
            case R.id.path_measure_test:
                Intent pathMeasureIntent = new Intent(this, PathMeasureActivity.class);
                startActivity(pathMeasureIntent);
                break;
            case R.id.matrix_test:
                Intent matrixTestIntent = new Intent(this, MatrixTestActivity.class);
                startActivity(matrixTestIntent);
                break;
            case R.id.matrix_camera_test:
                Intent matrixCameraIntent = new Intent(this, MatrixCameraActivity.class);
                startActivity(matrixCameraIntent);
                break;
            case R.id.multi_touch_test:
                Intent multiTouchIntent = new Intent(this, MultiTouchActivity.class);
                startActivity(multiTouchIntent);
                break;
            case R.id.animation_test:
                Intent animationIntent = new Intent(this, AnimationTestActivity.class);
                startActivity(animationIntent);
                break;
        }
        return true;
    }

    //    private Map<String, String> resultMap = new HashMap<>();
    private Handler mHandler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case SDK_PAY_FLAG:
                    PayResult result = new PayResult((Map<String, String>) msg.obj);
                    String resultInfo = result.getResult();
                    String resultStatus = result.getResultStatus();
                    if (TextUtils.equals(resultStatus, "9000"))
                    {
                        showToast("支付成功");
                    } else
                    {
                        showToast("支付失败");
                    }
                    break;
            }
        }
    };

    Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID);
    String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
    String sign = OrderInfoUtil2_0.getSign(params, RSA_PRIVATE);
    // 订单信息
    final String orderInfo = orderParam + "&" + sign;

    class AlipayThread extends Thread
    {
        @Override
        public void run()
        {
            PayTask alipay = new PayTask(MainActivity.this);
            Map<String, String> resultMap = alipay.payV2(orderInfo, true);
            Log.i("msp", resultMap.toString());

            Message msg = new Message();
            msg.what = SDK_PAY_FLAG;
            msg.obj = resultMap;
            mHandler.sendMessage(msg);
        }
    }
}
