package com.divination.crossing.apocalipse;


public class CameraController {


    // ==========================
    // POSIÇÃO DA CÂMERA
    // ==========================

    private float cameraX;

    private float cameraY;



    // ==========================
    // ZOOM
    // ==========================

    private float zoom;


    private final float MAX_ZOOM =
            0.90f;


    private final float MIN_ZOOM =
            0.70f;





    // ==========================
    // SUAVIDADE
    // ==========================

    private float followSpeed;





    // ==========================
    // EFEITO DE IMPACTO
    // ==========================

    private float shakePower;

    private int shakeTimer;






    public CameraController(){


        cameraX = 0;

        cameraY = 0;


        // Zoom padrão estilo Brave Heroes

        zoom = 0.90f;


        followSpeed = 0.12f;


        // Shake desligado inicialmente

        shakePower = 0;


        shakeTimer = 0;


    }







    // ==========================
    // SEGUIR HEROI
    // ==========================


    public void follow(
            float targetX,
            float targetY
    ){


        cameraX +=
                (targetX - cameraX)
                *
                followSpeed;



        cameraY +=
                (targetY - cameraY)
                *
                followSpeed;



    }







    // ==========================
    // ZOOM
    // ==========================


    public void setZoom(
            float value
    ){


        if(value > MAX_ZOOM){

            value = MAX_ZOOM;

        }



        if(value < MIN_ZOOM){

            value = MIN_ZOOM;

        }



        zoom = value;


    }







    public void zoomIn(){


        setZoom(
                zoom + 0.05f
        );


    }







    public void zoomOut(){


        setZoom(
                zoom - 0.05f
        );


    }







    // ==========================
    // SHAKE LEVE DE IMPACTO
    // ==========================


    public void shake(
