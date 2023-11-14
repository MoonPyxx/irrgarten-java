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
        int size = validMoves.length;
        boolean contained = false;
        
        for (Directions d: validMoves){
            if (d == direction){
                contained = true;
                break;
            }
        }
        if (size > 0 && !contained){
            return validMoves[0];
        } else {
            return direction;
        }
    }
    public float attack(){
        return strength + sumWeapons();
    }
    public boolean defend(float receivedAttack){
        return manageHit(receivedAttack);
    }
    public void receiveReward(){
        int wReward = Dice.weaponsReward();
        int sReward = Dice.shieldsReward();
        System.out.println("w " + wReward);
        System.out.println("s : " + sReward);
        for (int i = 0; i < wReward; i++){
            Weapon wnew = newWeapon();
            receiveWeapon(wnew);
        }
        for (int i = 0; i < sReward; i++){
            Shield snew = newShield();
            receiveShield(snew);
        }
        int extraHealth = Dice.healthReward();
        health += extraHealth;
    }
    public String toString(){
        return "Player [Name: " + name + ", Number: " + number + ", Intelligence: " + intelligence +
                ", Strength: " + strength + ", Health: " + health + ", Row: " + row + ", Col: " + col + "]" +"\n" + weapons.toString() + "\n" + shields.toString();
    }
    private void receiveWeapon(Weapon w){
        for (int i = 0; i < weapons.size(); i++){
            Weapon wi = weapons.get(i);
            boolean discard = wi.discard();
            if (discard){
                weapons.remove(i);
                i--;
            }
        }
        int size = weapons.size();
        if (size < MAX_SHIELDS){
            weapons.add(w);
        }
    }
    private void receiveShield(Shield s){
        for (int i = 0; i < shields.size(); i++){
            Shield si = shields.get(i);
            boolean discard = si.discard();
            if (discard){
                shields.remove(i);
                i--;
            }
        }
        int size = shields.size();
        if (size < MAX_SHIELDS){
            shields.add(s);
        }
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
        float defense = defensiveEnergy();
        boolean lose;
        if (defense < receivedAttack){
            gotWounded();
            incConsecutiveHits();
        } else {
            resetHits();
        }
        if ((consecutiveHits == HITS2LOSE) || dead()){
            resetHits();
            lose = true;
        } else{
            lose = false;
        }
        return lose;
        
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
    // setter temporal
    public void setHealth(int h){
        health = h;
    }
    
    
}