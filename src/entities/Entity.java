package entities;

import java.text.DecimalFormat;
import java.util.Random;

public class Entity {
    public String name;
    protected int attack_power;
    protected int strength;
    protected int crit_chance;
    protected int crit_damage;
    public float health;
    protected int defense;
    public Entity(String name, int attack_power, int strength, int crit_chance, int crit_damage, float health, int defense) {
        this.name = name;
        this.attack_power = attack_power;
        this.strength = strength;
        this.crit_chance = crit_chance;
        this.crit_damage = crit_damage;
        this.health = health;
        this.defense = defense;
    }
    DecimalFormat df = new DecimalFormat("#.##");
    Random random = new Random();
    public float cal(int attack_power, int strength, int crit_chance, int crit_damage, int opp_defense){
        float roll = random.nextFloat();
        if (roll < (crit_chance/100.0)){
            float damage = (float)(attack_power*(1+(strength/100.0))*(1+(crit_damage/100.0))*(1-(opp_defense/(opp_defense+200.0))));
            System.out.println("Critical Hit!!!");
            return damage;
        } else{
            float damage = (float)(attack_power*(1+(strength/100.0))*(1-(opp_defense/(opp_defense+200.0))));
            return damage;
        }
    }

    public void hit(Entity target){
        float roll = random.nextFloat();
        if (roll < 0.8) {
            float damage = cal(attack_power, strength, crit_chance, crit_damage, target.defense);
            System.out.println(name + " hits " + target.name + " for " + df.format(damage) + " damage!");
            target.health -= damage;
        } else {
            System.out.println(name + " missed his hit!");
        }
    }
    public void slash(Entity target){
        float roll = random.nextFloat();
        if (roll < 0.6) {
            float damage = cal(attack_power, strength, crit_chance, crit_damage, target.defense);
            float eff_damage = (float)(damage*1.3);
            System.out.println(name + " slashed " + target.name + " for " + df.format(eff_damage) + " damage!");
            target.health -= eff_damage;
        } else {
            System.out.println(name + " missed his slash!");
        }
    }
    public void shoot(Entity target){
        float roll = random.nextFloat();
        if (roll < 0.4) {
            float damage = cal(attack_power, strength, crit_chance, crit_damage, target.defense);
            float eff_damage = (float)(damage*1.7);
            System.out.println(name + " shot " + target.name + " for " + df.format(eff_damage) + " damage!");
            target.health -= eff_damage;
        } else {
            System.out.println(name + " missed his shot!");
        }
    }
}
