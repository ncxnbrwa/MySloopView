package test.mysloopview.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.orhanobut.logger.Logger;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import test.mysloopview.MyView.PieView;
import test.mysloopview.R;
import test.mysloopview.bean.PieDatas;

@ContentView(R.layout.activity_pie_chart)
public class PieChartActivity extends BaseActivity
{
    @ViewInject(R.id.pie_toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.pieview)
    private PieView mPieView;
    List<PieDatas> datases = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (datases == null)
        {
            datases = new ArrayList<>();
        }
        datases.add(new PieDatas("nicolas", 60));
        datases.add(new PieDatas("nicolas", 30));
        datases.add(new PieDatas("nicolas", 40));
        datases.add(new PieDatas("nicolas", 20));
        datases.add(new PieDatas("nicolas", 20));
        mPieView.setData(datases);
        Logger.d(datases);
    }

}
