package test.mysloopview.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import test.mysloopview.R;

@ContentView(R.layout.activity_draw_text_test)
public class DrawTextTestActivity extends BaseActivity
{
    @ViewInject(R.id.text_toolbar)
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
