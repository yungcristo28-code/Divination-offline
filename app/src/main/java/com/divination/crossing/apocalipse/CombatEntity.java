package com.divination.crossing.apocalipse;


public class CombatEntity {


    protected float x;
    protected float y;



    protected float hp;
    protected float maxHp;



    protected float attack;
    protected float defense;
    protected float speed;



    protected boolean alive;




    public CombatEntity(
            float x,
            float y,
            float maxHp,
            float attack,
            float defense,
            float speed
    ){


        this.x = x;
        this.y = y;


        this.maxHp = maxHp;

        this.hp = maxHp;


        this.attack = attack;

        this.defense = defense;

        this.speed = speed;


        this.alive = true;

    }





    // ==========================
    // RECEBER DANO
    // ==========================


    public void takeDamage(
            float damage
    ){


        if(!alive){

            return;

        }



        float finalDamage =
                damage - defense;



        if(finalDamage < 1){

            finalDamage = 1;

        }



        hp -= finalDamage;



        if(hp <= 0){

            hp = 0;

            alive = false;

        }

    }





    // ==========================
    // CURA
    // ==========================


    public void heal(
            float amount
    ){


        if(!alive){

            return;

        }



        hp += amount;



        if(hp > maxHp){

            hp = maxHp;

        }

    }





    // ==========================
    // MOVIMENTO
    // ==========================


    public void move(
            float dx,
            float dy
    ){

        x += dx;

        y += dy;

    }





    // ==========================
    // POSIÇÃO
    // ==========================


    public float getX(){

        return x;

    }



    public float getY(){

        return y;

    }



    public void setPosition(
            float x,
            float y
    ){

        this.x = x;

        this.y = y;

    }





    // ==========================
    // STATUS
    // ==========================


    public float getHp(){

        return hp;

    }



    public float getMaxHp(){

        return maxHp;

    }



    public float getAttack(){

        return attack;

    }



    public float getDefense(){

        return defense;

    }



    public float getSpeed(){

        return speed;

    }



    public boolean isAlive(){

        return alive;

    }



}
