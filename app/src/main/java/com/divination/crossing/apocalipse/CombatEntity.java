package com.divination.crossing.apocalipse;

public class CombatEntity {

    protected float x;
    protected float y;

    protected float hp;
    protected float maxHp;

    protected float attack;
    protected float defense;
    protected float speed;

    protected boolean alive = true;

    public CombatEntity(
            float x,
            float y,
            float maxHp,
            float attack,
            float defense,
            float speed
    ) {
        this.x = x;
        this.y = y;

        this.hp = maxHp;
        this.maxHp = maxHp;

        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public void takeDamage(float damage) {
        if (!alive) {
            return;
        }

        float finalDamage = Math.max(1, damage - defense);

        hp -= finalDamage;

        if (hp <= 0) {
            hp = 0;
            alive = false;
        }
    }

    public void heal(float amount) {
        if (!alive) {
            return;
        }

        hp += amount;

        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getHp() {
        return hp;
    }

    public float getMaxHp() {
        return maxHp;
    }

    public float getAttack() {
        return attack;
    }

    public float getDefense() {
        return defense;
    }

    public float getSpeed() {
        return speed;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
