package com.divination.crossing.apocalipse;

import java.util.ArrayList;
import java.util.Iterator;


public class BattleSystem {


    private Hero player;


    private ArrayList<Enemy> enemies;

    private ArrayList<Hero> summons;



    private EffectManager effectManager;

    private DamageManager damageManager;



    private int wave;

    private int gold;



    public BattleSystem(Hero player){


        this.player = player;


        enemies = new ArrayList<>();

        summons = new ArrayList<>();


        effectManager =
                new EffectManager();


        damageManager =
                new DamageManager();


        wave = 1;

        gold = 500;

    }





    // ==========================
    // ADICIONAR INIMIGO
    // ==========================


    public void addEnemy(
            Enemy enemy
    ){

        enemies.add(enemy);

    }





    // ==========================
    // ATAQUE DO HEROI
    // ==========================


    public void playerAttack(){


        Enemy target =
                getClosestEnemy();



        if(target == null){

            return;

        }



        float hpBefore =
                target.getHp();



        player.attack(target);



        int damage =
                (int)(
                hpBefore -
                target.getHp()
                );



        damageManager.addDamage(

                target.getX(),

                target.getY() - 50,

                damage

        );



        effectManager.addEffect(

                target.getX(),

                target.getY(),

                15,

                "SLASH"

        );


    }





    // ==========================
    // SUMMON
    // ==========================


    public boolean summonHero(
            Hero ally,
            int cost
    ){


        if(gold < cost){

            return false;

        }



        gold -= cost;


        summons.add(ally);


        return true;

    }





    // ==========================
    // ATUALIZA BATALHA
    // ==========================


    public void update(){



        effectManager.update();


        damageManager.update();




        Iterator<Enemy> iterator =
                enemies.iterator();




        while(iterator.hasNext()){


            Enemy enemy =
                    iterator.next();



            if(!enemy.isAlive()){


                rewardEnemy(enemy);


                iterator.remove();


            }

            else {


                enemy.moveTowards(

                        player.getX()

                );


                enemy.updateAttack(

                        player

                );

            }

        }





        // aliados invocados atacam

        for(Hero ally : summons){


            Enemy target =
                    getClosestEnemy();



            if(target != null){

                ally.attack(target);

            }

        }


    }





    // ==========================
    // PEGAR INIMIGO
    // ==========================


    private Enemy getClosestEnemy(){


        if(enemies.size() == 0){

            return null;

        }


        return enemies.get(0);

    }





    // ==========================
    // RECOMPENSAS
    // ==========================


    private void rewardEnemy(
            Enemy enemy
    ){


        gold += enemy.getGoldReward();


        player.addExperience(

                enemy.getExperienceReward()

        );


    }





    // ==========================
    // GETTERS
    // ==========================


    public ArrayList<Enemy> getEnemies(){

        return enemies;

    }



    public ArrayList<Hero> getSummons(){

        return summons;

    }



    public EffectManager getEffectManager(){

        return effectManager;

    }



    public DamageManager getDamageManager(){

        return damageManager;

    }



    public Hero getPlayer(){

        return player;

    }



    public int getGold(){

        return gold;

    }



    public int getWave(){

        return wave;

    }


}
