package com.example.testapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.bumptech.glide.load.engine.Resource;

public class MyView extends View {
    Paint p1 = new Paint();
    Paint p2 = new Paint();
    Paint p3 = new Paint();
    Paint p4 = new Paint();
    Paint p5 = new Paint();

    static int myData_x[] = new int[30000];
    static int myData_y[] = new int[30000];
    static int myData_color[] = new int[30000];

    static int radius = 20; //펜 굵기
    static int whatColor = 0;

    static int dataNumber = 0;
    int mx, my;
    static Bitmap loadDrawImage;


    public MyView(Context context, AttributeSet attr) {
        super(context);
        p1.setColor(Color.RED);
        p2.setColor(Color.BLUE);
        p3.setColor(Color.YELLOW);
        p4.setColor(Color.GREEN);
        p5.setColor(Color.BLACK);

        myData_x[0] = 0;
        myData_y[0] = 0;
        myData_color[0] = 5;
    }

    @Override
    public void onDraw(Canvas canvas) {
        /* 배경 */
        Resources res = getResources();
        BitmapDrawable bd = null;
        bd = (BitmapDrawable) res.getDrawable(R.drawable.korea_map, null);
        Bitmap bit = bd.getBitmap();
        canvas.drawBitmap(bit, null, new Rect(0, 0, getWidth(), getHeight()), null);

        if (loadDrawImage != null) {
            canvas.drawBitmap(loadDrawImage, 0, 0, null);
        }

        /* 그림 */
        for (int i = 1; i <= dataNumber; i++) {
            if (myData_color[i] == 1) {
                canvas.drawCircle(myData_x[i], myData_y[i], radius, p1);
            }

            if (myData_color[i] == 2) {
                canvas.drawCircle(myData_x[i], myData_y[i], radius, p2);
            }

            if (myData_color[i] == 3) {
                canvas.drawCircle(myData_x[i], myData_y[i], radius, p3);
            }

            if (myData_color[i] == 4) {
                canvas.drawCircle(myData_x[i], myData_y[i], radius, p4);
            }

            if (myData_color[i] == 5) {
                canvas.drawCircle(myData_x[i], myData_y[i], radius, p5);
            }
        }
        invalidate(); // 화면을 모두 지우고 새로 그리는 것 => 실시간 갱신
    }

    /* 지금까지 그렸던 그림의 위치(x,y)값을 저장 */
    public void saveData() {
        myData_x[dataNumber] = mx;
        myData_y[dataNumber] = my;
        myData_color[dataNumber] = whatColor;
    }

    public boolean onTouchEvent(MotionEvent event) {
        mx = (int) event.getX();
        my = (int) event.getY();

        dataNumber += 1;
        saveData();

        return true;
    }

    static public void clearPaint() {
        if (dataNumber == 0) {
            return;
        } else {
            myData_x[dataNumber] = 0;
            myData_y[dataNumber] = 0;
            myData_color[dataNumber] = 0;
            dataNumber--;
        }
    }

    /* 현재까지 그린 그림을 Bitmap으로 반환합니다. */
    public Bitmap getCurrentCanvas() {
        Bitmap bitmap = Bitmap.createBitmap(this.getWidth(), this.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        this.draw(canvas);
        return bitmap;
    }

//    static public void savePaint() {
//        MyView.invalidate();
//        Bitmap saveBitmap = MyView.getCurrentCanvas();
//        CanvasIO.saveBitmap(this, saveBitmap);
//    }
//
//    static public void loadPaint() {
//        MyView.init();
//        loadDrawImage = CanvasIO.openBitmap(this);
//        MyView.invalidate();
//    }
}