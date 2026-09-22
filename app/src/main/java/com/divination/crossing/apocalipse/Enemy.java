package com.divination.crossing.apocalipse;

public class Enemy extends CombatEntity {

    private String name;

    private int goldReward;
    private int experienceReward;

    private boolean boss;
    private boolean miniBoss;
    private boolean mvp;

    public Enemy(
            String name,
            float x,
            float y,
            float hp,
            float attack,
            float defense,
            float speed
    ) {

        super(
                x,
                y,
                hp,
                attack,
                defense,
                speed
        );

        this.name = name;

        this.goldReward = 20;
        this.experienceReward = 10;
    }


    public void moveTowards(float targetX) {

        if (!alive) {
            return;
        }

        if (x < targetX) {
            x += speed;
        }

        else if (x > targetX) {
            x -= speed;
        }
    }


    public void attackTarget(CombatEntity target) {

        if (!alive) {
            return;
        }

        if (target != null && target.isAlive()) {

            target.takeDamage(attack);
        }
    }


    public String getName() {
        return name;
    }


    public int getGoldReward() {
        return goldReward;
    }


    public int getExperienceReward() {
        return experienceReward;
    }


    public void setRewards(
            int gold,
            int experience
    ) {

        this.goldReward = gold;
        this.experienceReward = experience;
    }


    public boolean isBoss() {
        return boss;
    }


    public boolean isMiniBoss() {
        return miniBoss;
    }


    public boolean isMvp() {
        return mvp;
    }


    public void setBoss(boolean value) {
        boss = value;
    }


    public void setMiniBoss(boolean value) {
        miniBoss = value;
    }


    public void setMvp(boolean value) {
        mvp = value;
    }
}
