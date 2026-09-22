package com.divination.crossing.apocalipse;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;



public class CharacterSprite {


    private Bitmap sprite;


    private float x;

    private float y;


    private float scale;


    private AnimationController animation;



    public CharacterSprite(){


        x = 0;

        y = 0;


        scale = 1.0f;


        animation =
                new AnimationController();

    }





    public void setSprite(
            Bitmap bitmap
    ){

        sprite = bitmap;

    }





    public void setPosition(
            float x,
            float y
    ){

        this.x = x;

        this.y = y;

    }





    public void update(){


        animation.update();


    }





    public void draw(
            Canvas canvas,
            Paint paint
    ){


        if(sprite == null){

            return;

        }



        canvas.drawBitmap(

                sprite,

                x,

                y,

                paint

        );


    }





    public AnimationController getAnimation(){


        return animation;


    }


}
