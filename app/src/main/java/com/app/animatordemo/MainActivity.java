package com.app.animatordemo;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;
    private Button mButton;
    public static float t;
    float screenWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView= (ImageView) findViewById(R.id.iv_image);
        mButton= (Button) findViewById(R.id.btn_start);

        DisplayMetrics metrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenWidth=metrics.widthPixels;
        t=screenWidth/200;

       mButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
           //    paowuxian();
                paowuxian1();
             //  paowuxian2();
           }
       });
    }

    /**
     * 抛物线
     */
    private void paowuxian() {
        ValueAnimator valueAnimator=ValueAnimator.ofObject(new MyTypeEvaluator(),new Point(0,0));
        valueAnimator.setDuration(3000);//设置持续时间
        valueAnimator.setInterpolator(new LinearInterpolator());//设置线性时间插值器
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Point point= (Point) valueAnimator.getAnimatedValue();
                mImageView.setX(point.getX());
                mImageView.setY(point.getY());
            }
        });
        valueAnimator.start();
    }

    private void paowuxian1(){
        ValueAnimator valueAnimator=ValueAnimator.ofFloat(0,screenWidth-mImageView.getWidth());
        valueAnimator.setDuration(3000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float x= (float) valueAnimator.getAnimatedValue();
                float y=0.002f*x*x;
                mImageView.setX(x);
                mImageView.setY(y);
            }
        });
        valueAnimator.start();
    }

    private void paowuxian2(){
        ValueAnimator valueAnimator=ValueAnimator.ofObject(new MyTypeEvaluator(),new Point(0,0),new Point(400,600));
        valueAnimator.setDuration(3000);//设置持续时间
        valueAnimator.setInterpolator(new LinearInterpolator());//设置线性时间插值器
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Point point= (Point) valueAnimator.getAnimatedValue();
                mImageView.setX(point.getX());
                mImageView.setY(point.getY());
            }
        });
        valueAnimator.start();
    }
}
