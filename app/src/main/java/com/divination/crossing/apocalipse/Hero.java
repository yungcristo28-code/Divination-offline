package com.divination.crossing.apocalipse;

public class Hero extends CombatEntity {

    private final String name;

    private int level;
    private int gold;
    private int diamonds;

    private float vampirism;

    public Hero(
            String name,
            float x,
            float y,
            float maxHp,
            float attack,
            float defense,
            float speed
    ) {
        super(x, y, maxHp, attack, defense, speed);

        this.name = name;
        this.level = 1;
        this.gold = 0;
        this.diamonds = 0;
        this.vampirism = 0.12f;
    }

    public void attack(CombatEntity target) {

        if (!alive || target == null || !target.isAlive()) {
            return;
        }

        float damage = attack;

        target.takeDamage(damage);

        /*
         * Vampirismo:
         * uma parte do dano causado retorna como HP.
         */
        float healing = damage * vampirism;

        heal(healing);
    }

    public void addGold(int amount) {
        if (amount > 0) {
            gold += amount;
        }
    }

    public boolean spendGold(int amount) {

        if (amount <= 0) {
            return true;
        }

        if (gold < amount) {
            return false;
        }

        gold -= amount;
        return true;
    }

    public void addDiamond(int amount) {

        if (amount > 0) {
            diamonds += amount;
        }
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getGold() {
        return gold;
    }

    public int getDiamonds() {
        return diamonds;
    }

    public float getVampirism() {
        return vampirism;
    }

    public void setVampirism(float vampirism) {

        if (vampirism < 0) {
            vampirism = 0;
        }

        this.vampirism = vampirism;
    }
}
