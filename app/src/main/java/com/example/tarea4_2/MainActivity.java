package com.example.tarea4_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private int centrox,centroy;
    private Lienzo lienzo;
    private Paint pincel=new Paint();
    private ConstraintLayout fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        fondo=findViewById(R.id.lienzo);
        lienzo=new Lienzo(this);
        lienzo.setOnTouchListener(this);

        //el color del pincel inicialmente sera blanco
        pincel.setARGB(255,255,255,255);
        pincel.setStrokeWidth(4);
        pincel.setStyle(Paint.Style.FILL);
        fondo.addView(lienzo);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        centrox= (int) motionEvent.getX();
        centroy= (int) motionEvent.getY();

        //generamos color aleatorio
        pincel.setARGB(255, (int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255));
        lienzo.invalidate();
        return true;
    }

    class Lienzo extends View {
        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(255, 255, 255);
            canvas.drawCircle(centrox, centroy, 100, pincel);
        }
    }
}