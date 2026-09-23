package com.divination.crossing.apocalipse;



public class AnimationController {



    private String currentAnimation;



    private int frame;



    private int maxFrames;



    private float frameTimer;



    private float frameDuration;



    private boolean loop;



    private boolean finished;







    public AnimationController(){



        currentAnimation = "IDLE";



        frame = 0;



        maxFrames = 4;



        frameTimer = 0;



        frameDuration = 1000f / 60f;



        loop = true;



        finished = false;



    }








    // ==========================
    // UPDATE 60 FPS
    // ==========================


    public void update(
            float deltaTime
    ){



        frameTimer += deltaTime;



        if(frameTimer >= frameDuration){



            frame++;



            frameTimer = 0;



            if(frame >= maxFrames){



                if(loop){


                    frame = 0;


                }
                else{


                    frame = maxFrames - 1;


                    finished = true;


                }



            }



        }



    }








    // Compatibilidade

    public void update(){


        update(
                16.6f
        );


    }







    // ==========================
    // TROCAR ANIMAÇÃO
    // ==========================


    public void setAnimation(
            String animation
    ){



        if(!currentAnimation.equals(animation)){



            currentAnimation = animation;



            frame = 0;



            frameTimer = 0;



            finished = false;





            switch(animation){



                case "ATTACK":

                    maxFrames = 6;

                    loop = false;

                    break;



                case "SKILL":

                    maxFrames = 8;

                    loop = false;

                    break;



                case "HIT":

                    maxFrames = 3;

                    loop = false;

                    break;



                case "DEATH":

                    maxFrames = 10;

                    loop = false;

                    break;



                case "RUN":

                    maxFrames = 6;

                    loop = true;

                    break;



                default:


                    maxFrames = 4;

                    loop = true;


                    break;


            }



        }


    }








    public String getAnimation(){


        return currentAnimation;


    }






    public int getFrame(){


        return frame;


    }






    public boolean isFinished(){


        return finished;


    }







    public void reset(){



        frame = 0;


        frameTimer = 0;


        finished = false;


    }




}
