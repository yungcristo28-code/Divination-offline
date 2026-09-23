package com.divination.crossing.apocalipse;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;



public class CharacterSprite {



    private Bitmap idle;

    private Bitmap attack;

    private Bitmap skill;

    private Bitmap hit;

    private Bitmap death;

    private Bitmap run;



    private Bitmap currentSprite;



    private float x;

    private float y;



    private float scale;



    private AnimationController animationController;



    private String currentState;







    public CharacterSprite(){



        x = 0;

        y = 0;


        scale = 1.0f;



        currentState = "IDLE";



        animationController =
                new AnimationController();


    }







    // ==========================
    // SPRITES
    // ==========================



    public void setIdle(
            Bitmap bitmap
    ){

        idle = bitmap;

        currentSprite = bitmap;

    }






    public void setAttack(
            Bitmap bitmap
    ){

        attack = bitmap;

    }






    public void setSkill(
            Bitmap bitmap
    ){

        skill = bitmap;

    }






    public void setHit(
            Bitmap bitmap
    ){

        hit = bitmap;

    }






    public void setDeath(
            Bitmap bitmap
    ){

        death = bitmap;

    }






    public void setRun(
            Bitmap bitmap
    ){

        run = bitmap;

    }







    // ==========================
    // ESTADO
    // ==========================



    public void changeState(
            String state
    ){



        currentState = state;



        animationController
                .setAnimation(
                        state
                );



        switch(state){



            case "ATTACK":


                if(attack != null)

                    currentSprite = attack;


                break;





            case "SKILL":


                if(skill != null)

                    currentSprite = skill;


                break;





            case "HIT":


                if(hit != null)

                    currentSprite = hit;


                break;





            case "DEATH":

            case "DEAD":


                if(death != null)

                    currentSprite = death;


                break;





            case "RUN":


                if(run != null)

                    currentSprite = run;


                break;





            default:


                if(idle != null)

                    currentSprite = idle;


                break;


        }


    }







    // ==========================
    // UPDATE
    // ==========================



    public void update(){


        animationController.update();


    }







    // ==========================
    // POSIÇÃO
    // ==========================



    public void setPosition(
            float x,
            float y
    ){


        this.x = x;

        this.y = y;


    }








    // ==========================
    // DESENHO
    // ==========================



    public void draw(
            Canvas canvas,
            Paint paint
    ){



        if(currentSprite == null){

            return;

        }



        float width =
                currentSprite.getWidth()
                *
                scale;



        float height =
                currentSprite.getHeight()
                *
                scale;





        RectF destination =
                new RectF(

                        x - width / 2,

                        y - height / 2,

                        x + width / 2,

                        y + height / 2

                );





        canvas.drawBitmap(

                currentSprite,

                null,

                destination,

                paint

        );



    }







    public void setScale(
            float value
    ){


        scale = value;


    }







    public AnimationController getAnimation(){


        return animationController;


    }







    public String getCurrentState(){


        return currentState;


    }



}
