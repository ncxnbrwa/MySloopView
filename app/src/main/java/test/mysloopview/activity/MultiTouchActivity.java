package test.mysloopview.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import test.mysloopview.R;

@ContentView(R.layout.activity_multi_touch)
public class MultiTouchActivity extends BaseActivity
{
    @ViewInject(R.id.multi_touch_toolbar)
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
