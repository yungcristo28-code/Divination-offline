package com.divination.crossing.apocalipse;


import java.util.ArrayList;



public class BattleField {


    // ==========================
    // FASE
    // ==========================

    private int stageNumber;



    // ==========================
    // POSIÇÃO DO HEROI
    // ==========================

    private float heroX;

    private float heroY;



    // ==========================
    // TORRES
    // ==========================

    private Tower alliedTower;


    private ArrayList<Tower> enemyTowers;



    // ==========================
    // BASE INIMIGA
    // ==========================

    private Tower enemyBase;



    // ==========================
    // MVP SYSTEM
    // ==========================

    private boolean mvpActive;


    private String currentMVP;





    public BattleField(
            int stageNumber
    ){


        this.stageNumber =
                stageNumber;



        heroX = 200;

        heroY = 400;



        enemyTowers =
                new ArrayList<>();



        mvpActive = false;


        currentMVP = "";



    }







    // ==========================
    // CONFIGURAÇÃO DA FASE
    // ==========================


    public void addEnemyTower(
            Tower tower
    ){


        enemyTowers.add(
                tower
        );


    }







    public void setAlliedTower(
            Tower tower
    ){


        alliedTower = tower;


    }







    public void setEnemyBase(
            Tower tower
    ){


        enemyBase = tower;


    }







    // ==========================
    // MVP EVENTO
    // ==========================


    public void spawnMVP(
            String name
    ){


        mvpActive = true;


        currentMVP = name;


    }






    public void removeMVP(){


        mvpActive = false;


        currentMVP = "";


    }







    public boolean hasMVP(){


        return mvpActive;


    }







    public String getCurrentMVP(){


        return currentMVP;


    }







    // ==========================
    // GETTERS
    // ==========================


    public int getStageNumber(){


        return stageNumber;


    }





    public float getHeroX(){


        return heroX;


    }





    public float getHeroY(){


        return heroY;


    }





    public ArrayList<Tower> getEnemyTowers(){


        return enemyTowers;


    }





    public Tower getEnemyBase(){


        return enemyBase;


    }





    public Tower getAlliedTower(){


        return alliedTower;


    }



}
