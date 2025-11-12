package entities;

public class Enemy extends Entity{
    public Enemy(String name, int attack_power, int strength, int crit_chance, int crit_damage, int health, int defense){
        super(name, attack_power, strength, crit_chance, crit_damage, health, defense);
    }
}
