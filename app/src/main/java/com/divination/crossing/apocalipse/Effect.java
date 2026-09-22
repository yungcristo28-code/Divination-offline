package com.divination.crossing.apocalipse;

public class Effect {

    private float x;
    private float y;

    private int duration;
    private int currentTime;

    private String type;

    private boolean active;


    public Effect(
            float x,
            float y,
            int duration,
            String type
    ){

        this.x = x;
        this.y = y;

        this.duration = duration;
        this.type = type;

        this.currentTime = 0;
        this.active = true;
    }


    public void update(){

        if(!active){
            return;
        }

        currentTime++;

        if(currentTime >= duration){

            active = false;
        }
    }


    public boolean isActive(){

        return active;
    }


    public float getX(){

        return x;
    }


    public float getY(){

        return y;
    }


    public String getType(){

        return type;
    }


    public int getLife(){

        return duration - currentTime;
    }
}
