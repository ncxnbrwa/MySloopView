package test.mysloopview.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import test.mysloopview.R;
import test.mysloopview.SloopAnimation;

@ContentView(R.layout.activity_animation_test)
public class AnimationTestActivity extends BaseActivity
{
    @ViewInject(R.id.btn_anim)
    private Button btnAnim;
    @ViewInject(R.id.anim_toolbar)
    private Toolbar toolbar;
    SloopAnimation sa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        sa = new SloopAnimation();
        sa.setDuration(2000);
    }

    @Event(R.id.btn_anim)
    private void onClick(View v)
    {
        v.startAnimation(sa);
    }
}
