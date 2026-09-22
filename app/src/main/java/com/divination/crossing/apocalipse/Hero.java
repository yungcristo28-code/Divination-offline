package com.divination.crossing.apocalipse;


public class Hero extends CombatEntity {


    private final String name;


    // PROGRESSÃO

    private int level;

    private int experience;

    private int experienceNext;



    // ECONOMIA

    private int gold;

    private int diamonds;



    // COMBATE

    private float vampirism;

    private String state;



    public Hero(
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


        level = 1;

        experience = 0;

        experienceNext = 100;



        gold = 0;

        diamonds = 0;



        // Igor começa com roubo de vida

        vampirism = 0.12f;



        state = "IDLE";

    }





    // ==========================
    // ATAQUE
    // ==========================


    public void attack(
            CombatEntity target
    ){


        if(
                !alive ||
                target == null ||
                !target.isAlive()
        ){

            return;

        }



        float damage =
                attack;



        target.takeDamage(
                damage
        );



        // Vampirismo

        float healing =
                damage * vampirism;


        heal(
                healing
        );


        state = "ATTACK";


    }





    // ==========================
    // EXPERIÊNCIA
    // ==========================


    public void addExperience(
            int amount
    ){


        if(amount <= 0){

            return;

        }



        experience += amount;



        while(
                experience >= experienceNext
        ){

            levelUp();

        }

    }





    private void levelUp(){


        experience -= experienceNext;


        level++;


        experienceNext =
                level * 100;



        // crescimento básico

        maxHp += 80;

        hp = maxHp;


        attack += 12;


        defense += 5;


    }





    // ==========================
    // OURO
    // ==========================


    public void addGold(
            int amount
    ){

        if(amount > 0){

            gold += amount;

        }

    }




    public boolean spendGold(
            int amount
    ){


        if(amount <= 0){

            return true;

        }



        if(gold < amount){

            return false;

        }



        gold -= amount;


        return true;

    }





    // ==========================
    // DIAMANTES
    // ==========================


    public void addDiamond(
            int amount
    ){

        if(amount > 0){

            diamonds += amount;

        }

    }





    // ==========================
    // ESTADO
    // ==========================


    public void setState(
            String state
    ){

        this.state = state;

    }



    public String getState(){

        return state;

    }





    // ==========================
    // GETTERS
    // ==========================


    public String getName(){

        return name;

    }



    public int getLevel(){

        return level;

    }



    public int getExperience(){

        return experience;

    }



    public int getExperienceNext(){

        return experienceNext;

    }



    public int getGold(){

        return gold;

    }



    public int getDiamonds(){

        return diamonds;

    }



    public float getVampirism(){

        return vampirism;

    }




    public void setVampirism(
            float value
    ){

        if(value < 0){

            value = 0;

        }


        vampirism = value;

    }


}
