package com.divination.crossing.apocalipse;



public class MovementSystem {



    // ==========================
    // POSIÇÃO
    // ==========================

    private float x;

    private float y;





    // ==========================
    // MOVIMENTO
    // ==========================

    private float speed;


    private boolean movingLeft;


    private boolean movingRight;





    // ==========================
    // LIMITES DO MAPA
    // ==========================

    private float minX;

    private float maxX;





    public MovementSystem(){


        x = 200;

        y = 400;



        speed = 6.0f;



        movingLeft = false;


        movingRight = false;




        minX = 100;


        maxX = 3000;



    }







    // ==========================
    // CONTROLE
    // ==========================


    public void moveLeft(){


        movingLeft = true;


    }







    public void moveRight(){


        movingRight = true;


    }







    public void stop(){


        movingLeft = false;


        movingRight = false;


    }







    // ==========================
    // UPDATE
    // ==========================


    public void update(){



        if(movingLeft){


            x -= speed;


        }




        if(movingRight){


            x += speed;


        }




        // limita no mapa


        if(x < minX){


            x = minX;


        }



        if(x > maxX){


            x = maxX;


        }



    }







    // ==========================
    // CONFIGURAÇÃO
    // ==========================


    public void setPosition(
            float x,
            float y
    ){


        this.x = x;


        this.y = y;


    }







    public void setSpeed(
            float speed
    ){


        if(speed > 0){


            this.speed = speed;


        }


    }







    public void setLimits(
            float minX,
            float maxX
    ){


        this.minX = minX;


        this.maxX = maxX;


    }







    // ==========================
    // GETTERS
    // ==========================


    public float getX(){


        return x;


    }





    public float getY(){


        return y;


    }





    public boolean isMoving(){


        return movingLeft || movingRight;


    }




}
