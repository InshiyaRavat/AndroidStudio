package com.inshiya.trafficlight;

import android.content.Context;
import android.graphics.*;
import android.view.View;
import android.os.Handler;


public class Drawing extends View {
    private Paint redbrush;
    private Paint greenbrush;
    private Paint yellowbrush;
    private Paint brush,blackbrush;
    int i=1;

    public Drawing(Context context){
        super(context);
        init();
    }
    public void init(){
        redbrush=new Paint(Paint.ANTI_ALIAS_FLAG);
        greenbrush=new Paint(Paint.ANTI_ALIAS_FLAG);
        yellowbrush=new Paint(Paint.ANTI_ALIAS_FLAG);
        brush=new Paint(Paint.ANTI_ALIAS_FLAG);
        blackbrush=new Paint(Paint.ANTI_ALIAS_FLAG);

        brush.setColor(Color.WHITE);
        brush.setStyle(Paint.Style.STROKE);
        brush.setColor(Color.BLACK);
        brush.setStrokeWidth(15f);

        blackbrush.setColor(Color.BLACK);

        redbrush.setColor(Color.RED);

        greenbrush.setColor(Color.GREEN);

        yellowbrush.setColor(Color.YELLOW);
    }
    @Override
    protected void onDraw(Canvas canvas){
            canvas.drawRect(50,50,350,950,blackbrush);
            canvas.drawRect(160,950,250,1500,blackbrush);
            canvas.drawCircle(200,200,100f,brush);
            canvas.drawCircle(200,500,100f,brush);
            canvas.drawCircle(200,800,100f,brush);

            if(i==1){
                canvas.drawCircle(200,200,100f,redbrush);
                i=2;
            }
            else if(i==2){
                canvas.drawCircle(200,500,100f,greenbrush);
                i=3;
            }
            else if(i==3){
                canvas.drawCircle(200,800,100f,yellowbrush);
                i=1;
            }
            new Handler().postDelayed(new Runnable(){

                @Override
                public void run() {
                    invalidate();
                }
            },1000);
//            invalidate();
//            onDraw(canvas);
            canvas.save();
            super.onDraw(canvas);
    }
}

