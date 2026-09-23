package com.divination.crossing.apocalipse;


public class GameManager {


    private static GameManager instance;


    private Hero activeHero;


    private BattleSystem battleSystem;


    private int currentStage;





    private GameManager(){



        createHero();



        currentStage = 1;



        battleSystem =
                new BattleSystem(
                        activeHero
                );



        createStage();


    }





    // ==========================
    // CRIAR HEROI
    // ==========================


    private void createHero(){



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



        activeHero.addGold(
                500
        );


    }






    // ==========================
    // INSTANCIA UNICA
    // ==========================


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



        // INIMIGO 1


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





        // INIMIGO 2


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







    // ==========================
    // GETTERS
    // ==========================


    public Hero getActiveHero(){


        return activeHero;


    }





    public BattleSystem getBattleSystem(){


        return battleSystem;


    }





    public int getCurrentStage(){


        return currentStage;


    }




    public void setCurrentStage(
            int stage
    ){


        if(stage > 0){

            currentStage = stage;

        }


    }



}
