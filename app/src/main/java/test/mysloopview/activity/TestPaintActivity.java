package test.mysloopview.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import test.mysloopview.R;

@ContentView(R.layout.activity_test_paint)
public class TestPaintActivity extends BaseActivity
{
    @ViewInject(R.id.paint_toolbar)
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
