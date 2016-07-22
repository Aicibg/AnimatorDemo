package com.app.animatordemo;

import android.animation.TypeEvaluator;

/**
 * MyTypeEvaluator Created on 2016/7/22-10:23
 * Description:自定义估值器
 * Created by DongHao
 */
public class MyTypeEvaluator implements TypeEvaluator<Point>{

    @Override
    public Point evaluate(float v, Point startPoint, Point endPoint) {
        Point point=new Point();
//        point.x=200*(v*MainActivity.t);
//        point.y=100*(v*MainActivity.t)*(v*MainActivity.t);
        point.x=startPoint.x+v*(endPoint.x-startPoint.x);
        point.y=startPoint.y+v*(endPoint.y-startPoint.y);
        return point;
    }
}
