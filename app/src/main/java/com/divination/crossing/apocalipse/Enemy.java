package com.divination.crossing.apocalipse;


public class Enemy extends CombatEntity {


    private String name;


    private int experienceReward;

    private int goldReward;

    private int diamondChance;



    private boolean boss;



    private float attackRange;

    private float attackCooldown;

    private float attackTimer;




    public Enemy(
            String name,
            float x,
            float y,
            float maxHp,
            float attack,
            float defense,
            float speed
    ){


        super(
                x,
                y,
                maxHp,
                attack,
                defense,
                speed
        );


        this.name = name;


        experienceReward = 25;

        goldReward = 20;

        diamondChance = 2;



        boss = false;



        attackRange = 80;

        attackCooldown = 60;

        attackTimer = 0;

    }





    // ==========================
    // MOVIMENTO
    // ==========================


    public void moveTowards(
            float targetX
    ){


        if(!alive){

            return;

        }



        if(x < targetX){

            x += speed;

        }

        else if(x > targetX){

            x -= speed;

        }

    }





    // ==========================
    // ATAQUE AUTOMÁTICO
    // ==========================


    public void updateAttack(
            Hero player
    ){


        if(!alive){

            return;

        }



        attackTimer++;



        if(
                Math.abs(
                        x - player.getX()
                )
                <= attackRange
                &&
                attackTimer >= attackCooldown
        ){


            player.takeDamage(
                    attack
            );


            attackTimer = 0;

        }

    }





    // ==========================
    // BOSS / MVP
    // ==========================


    public void setBoss(
            boolean value
    ){

        boss = value;

    }



    public boolean isBoss(){

        return boss;

    }





    // ==========================
    // RECOMPENSAS
    // ==========================


    public int getExperienceReward(){

        return experienceReward;

    }



    public int getGoldReward(){

        return goldReward;

    }



    public int getDiamondChance(){

        return diamondChance;

    }





    // ==========================
    // INFORMAÇÕES
    // ==========================


    public String getName(){

        return name;

    }



}
