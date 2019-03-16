package com.android.roger.finalbolasrebotando;

import android.widget.ImageView;
import android.widget.Toast;

public class Pelota {
    ImageView bola;
    float velocidadY, velocidadX;

    public Pelota(float velY, float velX) {
        this.velocidadY = velY;
        this.velocidadX = velX;
    }

    public ImageView getPelota() {
        return bola;
    }

    public void setPelota(ImageView pelota) {
        this.bola = pelota;
    }

    public float getVelY() {
        return velocidadY;
    }

    public void setVelY(float velY) {
        this.velocidadY = velY;
    }

    public float getVelX() {
        return velocidadX;
    }

    public void setVelX(float velX) {
        this.velocidadX = velX;
    }

    public void movimientoPelota(float x, float y) {
        //hacia la derecha
        float siguientePosicionX = bola.getX() + x * velocidadX;
        if ((bola.getX() > 0)) {
            if (siguientePosicionX + bola.getWidth() < MainActivity.width) {
                bola.setX(siguientePosicionX);
            } else {
                bola.setX(MainActivity.width - bola.getWidth());
                velocidadX = (-1) * velocidadX;
            }
            //hacia la izquierda
        }else{
            if(siguientePosicionX>0){
                bola.setX(siguientePosicionX);
            }else{
                bola.setX(0);
                velocidadX=(-1)*velocidadX;
            }
        }
        //hacia abajo
        float siguientePosicionY = bola.getY() + y * velocidadY;
        if ((bola.getY() > 0)) {
            if (siguientePosicionY + bola.getHeight() < MainActivity.height) {
                bola.setY(siguientePosicionY);
            } else {
                bola.setY(MainActivity.height - bola.getHeight());
                velocidadY = (-1) * velocidadY;
            }
            //hacia arriba
        }else{
            if(siguientePosicionY>0){
                bola.setY(siguientePosicionY);
            }else{
                bola.setY(0);
                velocidadY=(-1)*velocidadY;
            }
        }
    }
}