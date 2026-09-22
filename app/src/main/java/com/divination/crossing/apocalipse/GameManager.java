package com.divination.crossing.apocalipse;


public class GameManager {


    private static GameManager instance;



    private Hero activeHero;


    private BattleSystem battleSystem;



    private int currentStage;





    private GameManager(){



        activeHero =
                new Hero(
                        "Igor",
                        250,
                        300,
                        1000,
                        80,
                        20,
                        4
                );



        activeHero.addGold(500);



        currentStage = 1;



        battleSystem =
                new BattleSystem(
                        activeHero
                );



        createStage();

    }





    public static GameManager getInstance(){


        if(instance == null){

            instance =
                    new GameManager();

        }


        return instance;

    }





    // ==========================
    // CRIAR FASE
    // ==========================


    private void createStage(){


        battleSystem.addEnemy(

                new Enemy(
                        "Goblin Sombrio",
                        650,
                        300,
                        300,
                        30,
                        5,
                        1.2f
                )

        );



        battleSystem.addEnemy(

                new Enemy(
                        "Lobo Abissal",
                        850,
                        320,
                        450,
                        40,
                        8,
