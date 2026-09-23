package com.divination.crossing.apocalipse;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Context;



public class SpriteManager {



    private static SpriteManager instance;



    private Bitmap igorIdle;

    private Bitmap igorAttack;

    private Bitmap igorHit;



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



        try {



            igorIdle =
                    BitmapFactory.decodeResource(
                            context.getResources(),
                            context.getResources()
                                    .getIdentifier(
                                            "igor_idle",
                                            "drawable",
                                            context.getPackageName()
                                    )
                    );



            igorAttack =
                    BitmapFactory.decodeResource(
                            context.getResources(),
                            context.getResources()
                                    .getIdentifier(
                                            "igor_attack",
                                            "drawable",
                                            context.getPackageName()
                                    )
                    );



            igorHit =
                    BitmapFactory.decodeResource(
                            context.getResources(),
                            context.getResources()
                                    .getIdentifier(
                                            "igor_hit",
                                            "drawable",
                                            context.getPackageName()
                                    )
                    );



        }

        catch(Exception e){



            igorIdle = null;

            igorAttack = null;

            igorHit = null;


        }



    }








    public Bitmap getIgorIdle(){


        return igorIdle;


    }






    public Bitmap getIgorAttack(){


        return igorAttack;


    }






    public Bitmap getIgorHit(){


        return igorHit;


    }





}
