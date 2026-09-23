package com.divination.crossing.apocalipse;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;



public class CharacterSprite {



    private Bitmap sprite;


    private Bitmap idle;

    private Bitmap attack;

    private Bitmap skill;

    private Bitmap hit;

    private Bitmap death;

    private Bitmap run;



    private float x;

    private float y;


    private float scale;



    private AnimationController animation;



    private String currentState;







    public CharacterSprite(){


        x = 0;

        y = 0;


        scale = 1.0f;


        animation =
                new AnimationController();



        currentState =
                "IDLE";


    }








    // ==========================
    // SPRITES
    // ==========================


    public void setIdle(Bitmap bitmap){


        idle = bitmap;

        if(sprite == null){

            sprite = bitmap;

        }


    }






    public void setAttack(Bitmap bitmap){


        attack = bitmap;


    }






    public void setSkill(Bitmap bitmap){


        skill = bitmap;


    }






    public void setHit(Bitmap bitmap){


        hit = bitmap;


    }






    public void setDeath(Bitmap bitmap){


        death = bitmap;


    }






    public void setRun(Bitmap bitmap){


        run = bitmap;


    }









    // ==========================
    // TROCA DE ESTADO
    // ==========================


    public void changeState(String state){



        currentState = state;



        animation.setAnimation(
                state
        );




        switch(state){



            case "ATTACK":

                if(attack != null)
                    sprite = attack;

                break;



            case "SKILL":

                if(skill != null)
                    sprite = skill;

                break;




            case "HIT":

                if(hit != null)
                    sprite = hit;

                break;




            case "DEATH":

                if(death != null)
                    sprite = death;

                break;




            case "RUN":

                if(run != null)
                    sprite = run;

                break;




            default:

                if(idle != null)
                    sprite = idle;


                break;


        }


    }








    public String getState(){


        return currentState;


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








    public void update(){


        animation.update();


    }









    // ==========================
    // DESENHO
    // ==========================


    public void draw(
            Canvas canvas,
            Paint paint
    ){



        if(sprite == null){

            return;

        }




        float width =
                sprite.getWidth()
                *
                scale;



        float height =
                sprite.getHeight()
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

                sprite,

                null,

                destination,

                paint

        );



    }








    public void setScale(
            float scale
    ){


        this.scale = scale;


    }








    public int getCurrentFrame(){


        return animation.getFrame();


    }








    public AnimationController getAnimation(){


        return animation;


    }



}
