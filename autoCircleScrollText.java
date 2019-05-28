package com.inforcreation.client.njkx.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunxufeng on 2017/3/28.
 */
public class autoCircleScrollText extends View implements View.OnTouchListener,View.OnClickListener{

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        System.out.println("11111111111111");
        return false;
    }

    @Override
    public void onClick(View v) {
        System.out.println("22222222222222");
    }

    private class Location{
        public float x;
        public float y;
    }

    private Paint mPaintText;
    private String cicrle_scroll_out = "";
    private String cicrle_scroll_inside = "";

    public static final int NEED_INVALIDATE = 0X23;
    int out_index = 0;
    int inside_index = 0;

    List<Location> loation_lst_out = new ArrayList<Location>();
    List<Location> loation_lst_inside = new ArrayList<Location>();

    //每隔一秒，在handler中调用一次重新绘制方法
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case NEED_INVALIDATE:
                    invalidate();//告诉UI主线程重新绘制
                    handler.sendEmptyMessageDelayed(NEED_INVALIDATE, 160);
                    break;
                default:
                    break;
            }
        }
    };

    public autoCircleScrollText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaintText = new Paint();
        mPaintText.setColor(Color.BLACK);
        mPaintText.setStrokeWidth(2);
        mPaintText.setDither(true);
        mPaintText.setAntiAlias(true);
//        mPaintText.setTextAlign(Paint.Align.CENTER);
        mPaintText.setTextSize(20);
        setText("","");
        for(int i = 0; i < 30;i++){
            Location location = new Location();

            location.x = (float) (260 + 260 * Math.cos(6 * (i + 1) * Math.PI / 180));
            location.y = (float)(260 - 260 * Math.sin(6 * (i + 1) * Math.PI / 180));
            System.out.println("x + " + location.x + " y + " + location.y);
            loation_lst_out.add(location);
        }

        for(int i = 0; i < 20;i++){
            Location location = new Location();
            location.x = (float)(260 + 180 * Math.cos(9*(i+1)*Math.PI/180));
            location.y = (float)(260 - 180 * Math.sin(9 * (i + 1) * Math.PI / 180));
            loation_lst_inside.add(location);
        }
        handler.sendEmptyMessage(NEED_INVALIDATE);//向handler发送一个消息，让它开启重绘
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        out_index ++ ;
        if (out_index == cicrle_scroll_out.length()){
            out_index = 0;
        }

        inside_index ++ ;
        if (inside_index == cicrle_scroll_inside.length()){
            inside_index = 0;
        }

        canvas.translate(0,30);
        if (cicrle_scroll_out == null || cicrle_scroll_out.length() == 0){

        }else {
            for (int i = 0; i < loation_lst_out.size(); i++) {
//            canvas.drawText(cicrle_scroll.charAt(i) + "", loation_lst.get(i).x, loation_lst.get(i).y, mPaintText);
                canvas.drawText(cicrle_scroll_out.charAt((30 + out_index - i) % cicrle_scroll_out.length()) + "", loation_lst_out.get(i).x, loation_lst_out.get(i).y, mPaintText);
            }
        }

        if (cicrle_scroll_inside == null || cicrle_scroll_inside.length() == 0){

        }else {
            for (int i = 0; i < loation_lst_inside.size(); i++) {
//            canvas.drawText(cicrle_scroll.charAt(i) + "", loation_lst.get(i).x, loation_lst.get(i).y, mPaintText);
                canvas.drawText(cicrle_scroll_inside.charAt((i + inside_index) % cicrle_scroll_inside.length()) + "", loation_lst_inside.get(i).x, loation_lst_inside.get(i).y, mPaintText);
            }
        }
    }

    public void setText(String text_out,String text_inside){
        cicrle_scroll_out = text_out;
        cicrle_scroll_inside = text_inside;
    }

    public void stopTimer(){
        if (handler != null){
            handler.removeMessages(NEED_INVALIDATE);
        }
    }
}
