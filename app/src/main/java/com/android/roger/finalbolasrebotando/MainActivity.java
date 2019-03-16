package com.android.roger.finalbolasrebotando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    static int statusBar, width, height;

   // Pelota p;
    Pelota[] p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout layout = findViewById(R.id.layoutBola);
        DisplayMetrics display = this.getBaseContext().getResources().getDisplayMetrics();
        width = display.widthPixels;
        height = display.heightPixels;
        //tipo de VELOCIDADES 
        float[] vel = {-2,2,4,-4,6,5,-6,-5};
        p = new Pelota[9];
        for(int i = 0; i<p.length;i++){
            p[i] = new Pelota(vel[new Random().nextInt(4)],vel[new Random().nextInt(4)]);

            p[i].bola = new ImageView(getApplicationContext());
            layout.addView(p[i].bola);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) p[i].bola.getLayoutParams();
            params.width = 120;
            params.height = 120;
            p[i].bola.setLayoutParams(params);
            p[i].bola.setImageResource(R.drawable.bola);
            p[i].bola.setX(height/10*2);
            p[i].bola.setY(width/10*2);
        }
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for(int i =0; i<p.length; i++) {
                    p[i].movimientoPelota(5,5);
                }
                //p.movimientoPelota(p.bola.getX(),p.bola.getY());
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 0,30);
    }
}

