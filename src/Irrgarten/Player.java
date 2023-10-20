package Irrgarten;

import java.util.ArrayList;

public class Player {
    private static int MAX_WEAPONS = 2;
    private static int MAX_SHIELDS = 3;
    private static int INITIAL_HEALTH = 10;
    private static int HITS2LOSE = 3;
    
    private String name;
    private char number;
    private float intelligence, strength, health;
    private int row, col, consecutiveHits=0;
    
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<Shield> shields = new ArrayList<>();

    
    public Player(char number, float intelligence, float strength){
        this.number = number;
        this.intelligence = intelligence;
        this.strength =  strength;
        this.name = "Player # " + number;
        this.health = INITIAL_HEALTH;
    }
    public Player(){
        
    }
    public void resurrect(){
        weapons.clear();
        shields.clear();    
        health = INITIAL_HEALTH;
        consecutiveHits = 0;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public char getNumber(){
        return number;
    }
    public void setPos(int row, int col){
        this.row = row;
        this.col = col;
    }
    public boolean dead(){
        return health <= 0;
    }
    public Directions move(Directions direction, Directions[] validMoves){
        return null;
    }
    public float attack(){
        return strength + sumWeapons();
    }
    public boolean defend(float receivedAttack){
        return manageHit(receivedAttack);
    }
    public void receiveAward(){
        
    }
    public String toString(){
        return "Player [Name: " + name + ", Number: " + number + ", Intelligence: " + intelligence + ", Strength: " + strength + ", Health: " + health + ", Row: " + row + ", Col: " + col + "]";
    }
    private void receiveWeapon(Weapon w){
        
    }
    private void receiveShield(Shield s){
        
    }
    private Weapon newWeapon(){
        float power = Dice.weaponPower();
        int uses = Dice.usesLeft();
        return new Weapon(power, uses);
    }
    private Shield newShield(){
        float power = Dice.shieldPower();
        int uses = Dice.usesLeft();
        return new Shield(power, uses);
    }
    private float sumWeapons(){
        float sum = 0.0f;
        for (Weapon w: weapons){
            sum += w.attack();
        }
        return sum;
    }
    private float sumShields(){
        float sum = 0.0f;
        for (Shield s: shields){
            sum += s.protect();
        }
        return sum;
    }
    private float defensiveEnergy(){
        return intelligence + sumShields();
    }
    private boolean manageHit(float receivedAttack){
        return false;
    }
    private void resetHits(){
        consecutiveHits = 0;
    }
    private void gotWounded(){
        health -= 1;
    }
    private void incConsecutiveHits(){
        consecutiveHits++;
    }
    
    
    
}