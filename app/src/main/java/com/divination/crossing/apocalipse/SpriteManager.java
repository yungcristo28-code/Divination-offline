package com.divination.crossing.apocalipse;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;



public class SpriteManager {


    private static SpriteManager instance;


    private Context context;



    // ==========================
    // SPRITES DO IGOR
    // ==========================

    private Bitmap igorIdle;
    private Bitmap igorAttack;
    private Bitmap igorRun;





    private SpriteManager(
            Context context
    ){

        this.context =
                context.getApplicationContext();

    }





    public static SpriteManager getInstance(
            Context context
    ){


        if(instance == null){

            instance =
                    new SpriteManager(
                            context
                    );

        }


        return instance;

    }






    // ==========================
    // CARREGAR SPRITES
    // ==========================


    public void loadSprites(){


        /*
        
        Futuro:

        igorIdle =
        BitmapFactory.decodeResource(
                context.getResources(),
                R.drawable.igor_idle
        );


        igorAttack =
        BitmapFactory.decodeResource(
                context.getResources(),
                R.drawable.igor_attack
        );


        igorRun =
        BitmapFactory.decodeResource(
                context.getResources(),
                R.drawable.igor_run
        );


        */


    }






    // ==========================
    // GETTERS
    // ==========================


    public Bitmap getIgorIdle(){

        return igorIdle;

    }



    public Bitmap getIgorAttack(){

        return igorAttack;

    }



    public Bitmap getIgorRun(){

        return igorRun;

    }




}
