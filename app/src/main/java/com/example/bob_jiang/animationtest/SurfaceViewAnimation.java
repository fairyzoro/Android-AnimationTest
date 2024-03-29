package com.example.bob_jiang.animationtest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Bob_JIANG on 10/10/2015.
 */

//Stuff about surfaceview: it can use another thread to draw stuff. You need one class to extend
// surfaceview and implement surfaceview.callback at the same time and then implement
// surfacecreated, surfacedistoryed, surfacechanged, where you can start thread in surfacecreated
// and stop thread in surfacedistoryed. What you do in the thread is basically getholder,
// lockcanvas and unlockcanvasdandpost
public class SurfaceViewAnimation extends Activity {
        @Override
            public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(new MyView(this));
        }

        //视图内部类
        class MyView extends SurfaceView implements SurfaceHolder.Callback
        {
            private SurfaceHolder holder;
            private MyThread myThread;
            public MyView(Context context) {
                super(context);
                // TODO Auto-generated constructor stub
                holder = this.getHolder();
                holder.addCallback(this);
                myThread = new MyThread(holder);//创建一个绘图线程
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                       int height) {
                // TODO Auto-generated method stub

            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                // TODO Auto-generated method stub
                myThread.isRun = true;
                myThread.start();
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                // TODO Auto-generated method stub
                myThread.isRun = false;
            }
        }
        //线程内部类
        class MyThread extends Thread
        {
            private SurfaceHolder holder;
            public boolean isRun ;
            public  MyThread(SurfaceHolder holder)
            {
                this.holder =holder;
                isRun = true;
            }
            @Override
            public void run()
            {
                int count = 0;
                while(isRun)
                {
                    Canvas c = null;
                    try {
                        synchronized (holder){
                            c = holder.lockCanvas();//锁定画布，一般在锁定后就可以通过其返回的画布对象Canvas，在其上面画图等操作了。
                            c.drawColor(Color.BLACK);//设置画布背景颜色
                            Paint p = new Paint(); //创建画笔
                            p.setColor(Color.WHITE);
                            p.setTextSize(100);
                            Rect r = new Rect(100, 50, 300, 250);
                            c.drawRect(r, p);
                            c.drawText("这是第"+(count++)+"秒", 100, 500, p);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally{
                        if(c!= null) {
                            holder.unlockCanvasAndPost(c);//结束锁定画图，并提交改变。
                        }
                    }
                }
            }
        }
}
