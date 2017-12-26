package test.mysloopview;

import android.app.Application;
import android.content.Context;

import org.xutils.x;

/**
* @ClassName: SloopApplication
* @Description: todo()
* @author xiong
* @date 2016/12/23
*/
public class SloopApplication extends Application
{
    private static Context mContext;

    @Override
    public void onCreate()
    {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        mContext = getApplicationContext();
    }

    public static Context getmContext()
    {
        return mContext;
    }
}
