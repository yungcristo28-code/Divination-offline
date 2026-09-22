package com.divination.crossing.apocalipse;

import java.util.ArrayList;
import java.util.Iterator;

public class BattleSystem {

    private Hero player;

private ArrayList<Enemy> enemies;
private ArrayList<Hero> summons;

private EffectManager effectManager;

    private int wave;
    private int gold;

    public BattleSystem(Hero player) {

    this.player = player;

    enemies = new ArrayList<>();
    summons = new ArrayList<>();

    effectManager = new EffectManager();

    wave = 1;
    gold = 500;
}


    // ==========================
    // ADICIONAR INIMIGO
    // ==========================

    public void addEnemy(Enemy enemy) {

        enemies.add(enemy);
    }


    // ==========================
    // ATAQUE DO IGOR
    // ==========================

    public void playerAttack() {

        Enemy target = getClosestEnemy();

        if(target != null){

            player.attack(target);

            if(!target.isAlive()){

                rewardEnemy(target);

                enemies.remove(target);
            }
        }
    }


    // ==========================
    // INIMIGO MAIS PRÓXIMO
    // ==========================

    private Enemy getClosestEnemy(){

        Enemy closest = null;

        float distance = Float.MAX_VALUE;


        for(Enemy enemy : enemies){

            float d =
                    Math.abs(
                            enemy.getX()
                    -
                            player.getX()
                    );


            if(d < distance){

                distance = d;
                closest = enemy;
            }
        }


        return closest;
    }



    // ==========================
    // RECOMPENSAS
    // ==========================

    private void rewardEnemy(
            Enemy enemy
    ){

        gold += enemy.getGoldReward();

        player.addGold(
                enemy.getGoldReward()
        );
    }



    // ==========================
    // SUMMON
    // ==========================

    public boolean summonHero(
            Hero hero
    ){

        int cost = 100 + (summons.size()*50);


        if(player.spendGold(cost)){

            summons.add(hero);

            return true;
        }


        return false;
    }



    // ==========================
    // ATUALIZA BATALHA
    // ==========================

    public void update(){

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
            }
        }


        // aliados atacam automaticamente

        for(Hero ally : summons){

            Enemy target =
                    getClosestEnemy();


            if(target != null){

                ally.attack(target);
            }
        }
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


    public int getGold(){

        return gold;
    }


    public int getWave(){

        return wave;
    }
}
