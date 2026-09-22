package com.divination.crossing.apocalipse;


public class AnimationController {


    private String currentAnimation;


    private int frame;


    private int frameSpeed;


    private int timer;



    public AnimationController(){


        currentAnimation = "IDLE";


        frame = 0;


        frameSpeed = 8;


        timer = 0;

    }





    public void update(){


        timer++;



        if(timer >= frameSpeed){


            frame++;


            timer = 0;

        }


    }





    public void setAnimation(
            String animation
    ){


        if(!currentAnimation.equals(animation)){


            currentAnimation = animation;


            frame = 0;


            timer = 0;

        }

    }





    public String getAnimation(){


        return currentAnimation;

    }





    public int getFrame(){


        return frame;

    }



}
