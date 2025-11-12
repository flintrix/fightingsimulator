import entities.*;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String turn = "player";

        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + " you will be fighting...");
        String[] enemies = {"goblin", "zombie", "skeleton", "dragon", "herobrine"};
        int[] attackPowers = {200, 100, 150, 500, 100};
        int[] strengths = {68, 112, 108, 240, 320};
        int[] crit_chances = {50, 30, 17, 4, 100};
        int[] crit_damages = {80, 112, 90, 240, 100};
        int[] healths = {800, 400, 600, 2000, 1500};
        int[] defenses = {375, 340, 260, 400, 876};
        int randomIndex = random.nextInt(enemies.length);
        String yourEnemy = enemies[randomIndex];
        int attackPower = attackPowers[randomIndex];
        int strength = strengths[randomIndex];
        int crit_chance = crit_chances[randomIndex];
        int crit_damage = crit_damages[randomIndex];
        int health = healths[randomIndex];
        int defense = defenses[randomIndex];
        System.out.println(yourEnemy);

        Player player = new Player(name, 200, 108, 67, 106, 800, 387);
        Enemy enemy = new Enemy(yourEnemy, attackPower, strength, crit_chance, crit_damage, health, defense);

        while (true) {
            int attack = random.nextInt(3);
            if (turn.equals("player")){
                System.out.println("What attack do you want to use? choose from \"hit\", \"slash\" or \"shoot\"");
                String choice = scanner.nextLine();
                if (choice.equals("hit")) {
                    player.hit(enemy);
                    if (enemy.health <= 0) {
                        System.out.println(player.name + " has won from " + enemy.name + ", he had " + df.format(player.health) + " hp left!");
                        break;
                    } else {
                        turn = "enemy";
                    }
                } else if (choice.equals("slash")) {
                    player.slash(enemy);
                    if (enemy.health <= 0) {
                        System.out.println(player.name + " has won from " + enemy.name + ", he had " + df.format(player.health) + " hp left!");
                        break;
                    } else {
                        turn = "enemy";
                    }
                } else if(choice.equals("shoot")){
                    player.shoot(enemy);
                    if (enemy.health <= 0) {
                        System.out.println(player.name + " has won from " + enemy.name + ", he had " + df.format(player.health) + " hp left!");
                        break;
                    } else {
                        turn = "enemy";
                    }
                } else{
                    System.out.println("That isn't one of the 3 attacks, choose from: \"hit\", \"slash\" or \"shoot\"");
                }
            } else {
                if (attack == 0) {
                    enemy.hit(player);
                    if (player.health <= 0) {
                        System.out.println(enemy.name + " has won from " + player.name + ", he had " + df.format(enemy.health) + " hp left!");
                        break;
                    } else {
                        turn = "player";
                        System.out.println(player.name + " has " + df.format(player.health) + " hp left!");
                        System.out.println(enemy.name + " has " + df.format(enemy.health) + " hp left!");
                    }
                } else if (attack == 1) {
                    enemy.slash(player);
                    if (player.health <= 0) {
                        System.out.println(enemy.name + " has won from " + player.name + ", he had " + df.format(enemy.health) + " hp left!");
                        break;
                    } else {
                        turn = "player";
                        System.out.println(player.name + " has " + df.format(player.health) + " hp left!");
                        System.out.println(enemy.name + " has " + df.format(enemy.health) + " hp left!");
                    }
                } else {
                    enemy.shoot(player);
                    if (player.health <= 0) {
                        System.out.println(enemy.name + " has won from " + player.name + ", he had " + df.format(enemy.health) + " hp left!");
                        break;
                    } else {
                        turn = "player";
                        System.out.println(player.name + " has " + df.format(player.health) + " hp left!");
                        System.out.println(enemy.name + " has " + df.format(enemy.health) + " hp left!");
                    }
                }
            }

        }}}