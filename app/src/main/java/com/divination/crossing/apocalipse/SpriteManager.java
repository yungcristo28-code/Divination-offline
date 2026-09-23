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

    private Bitmap igorSkill;

    private Bitmap igorHit;

    private Bitmap igorDeath;





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
        
        Aqui vamos ligar as artes HD
        quando elas entrarem em:

        app/src/main/res/drawable


        Exemplo:


        igorIdle =
        BitmapFactory.decodeResource(
                context.getResources(),
                R.drawable.igor_idle
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






    public Bitmap getIgorSkill(){


        return igorSkill;


    }






    public Bitmap getIgorHit(){


        return igorHit;


    }






    public Bitmap getIgorDeath(){


        return igorDeath;


    }



}
