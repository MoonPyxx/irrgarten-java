package Irrgarten;

public class Player {
    private static int MAX_WEAPONS = 2;
    private static int MAX_SHIELDS = 3;
    private static int INITIAL_HEALTH = 10;
    private static int HITS2LOSE = 3;
    
    private String name;
    private char number;
    private float intelligence, strength, health;
    private int row, col, consescutiveHits=0;
    
    
    public Player(char number, float intelligence, float strength){
        this.number = number;
        this.intelligence = intelligence;
        this.strength =  strength;
    }
    public void resurrect(){
        
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
        return false;
    }
    public Directions move(Directions direction, Directions[] validMoves){
        return null;
    }
    public float attack(){
        return 0.0f;
    }
    public boolean defend(float receivedAttack){
        return false;
    }
    public void receiveAward(){
        
    }
    public String toString(){
        return null;
    }
    private void receiveWeapon(Weapon w){
        
    }
    private void receiveShield(Shield s){
        
    }
    private Weapon newWeapon(){
        return null;
    }
    private Shield newShield(){
        return null;
    }
    private float sumWeapons(){
        return 0.0f;
    }
    private float defensiveEnergy(){
        return 0.0f;
    }
    private boolean manageHit(float receivedAttack){
        return false;
    }
    private void resetHits(){
        
    }
    private void gotWounded(){
        
    }
    private void incConsecutiveHits(){
        
    }
    
    
    
}