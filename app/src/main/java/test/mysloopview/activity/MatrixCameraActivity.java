package test.mysloopview.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import test.mysloopview.R;
import test.mysloopview.Rotate3dAnimation;

@ContentView(R.layout.activity_matrix_camera)
public class MatrixCameraActivity extends BaseActivity
{
    @ViewInject(R.id.matrix_camera_toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.iv_rotate)
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Event(R.id.iv_rotate)
    private void onClick(View v)
    {
        // 计算中心点（这里是使用view的中心作为旋转的中心点）
        final float centerX = v.getWidth() / 2.0f;
        final float centerY = v.getHeight() / 2.0f;

        //括号内参数分别为（上下文，开始角度，结束角度，x轴中心点，y轴中心点，深度，是否扭曲）
        final Rotate3dAnimation rotation
                = new Rotate3dAnimation(MatrixCameraActivity.this,
                0, 180, centerX, centerY, 0f, true);

        rotation.setDuration(3000);                         //设置动画时长
        rotation.setFillAfter(true);                        //保持旋转后效果
        rotation.setInterpolator(new LinearInterpolator());	//设置插值器
        v.startAnimation(rotation);
    }
}
