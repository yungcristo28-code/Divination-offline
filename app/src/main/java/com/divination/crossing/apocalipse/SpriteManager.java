package com.divination.crossing.apocalipse;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Context;


public class SpriteManager {


    private static SpriteManager instance;


    private Bitmap igorIdle;


    private Context context;




    private SpriteManager(
            Context context
    ){

        this.context = context;

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





    public void loadSprites(){


        /*
         Futuramente:
         
         igorIdle =
         BitmapFactory.decodeResource(
              context.getResources(),
              R.drawable.igor_idle
         );

        */


    }





    public Bitmap getIgorIdle(){

        return igorIdle;

    }


}
