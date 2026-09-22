package com.divination.crossing.apocalipse;

public class GameManager {

    private static GameManager instance;

    private Hero igor;
    private BattleSystem battleSystem;


    private GameManager(){

        igor = new Hero(
                "Igor",
                250,
                300,
                1000,
                80,
                20,
                4
        );


        igor.addGold(500);


        battleSystem =
                new BattleSystem(igor);


        createWave();

    }



    public static GameManager getInstance(){

        if(instance == null){

            instance = new GameManager();

        }

        return instance;
    }



    private void createWave(){

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
                        1.0f
                )

        );

    }



    public Hero getIgor(){

        return igor;

    }



    public BattleSystem getBattleSystem(){

        return battleSystem;

    }

}
