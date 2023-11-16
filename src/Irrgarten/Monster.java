package Irrgarten;

public class Monster {
    private static int INITIAL_HEALTH  = 5;
    private String name;
    private float intelligence, strength, health;
    private int row, col;
    
    public Monster (String name, float intelligence, float strength){
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        this.health = INITIAL_HEALTH;
    }
    public boolean dead(){
        return health <= 0;
    }
    public float attack(){
        return Dice.intensity(strength);
    }
    public boolean defend(float receivedAttack){
        if (dead()){
            return false;
        }
        float defensiveEnergy = Dice.intensity(intelligence);
             if (defensiveEnergy < receivedAttack){
                 gotWounded();
                 return dead();
        }
             return false;
        } 
    public void setPos(int row, int col){
        this.row = row;
        this.col = col;
    }
    public String toString(){
        return "Monster [Name: " + name + ", Intelligence: " + intelligence + ", Strength: " + strength + ", Health: " + health + ", Row: " + row + ", Col: " + col + "]";
    }
    public void gotWounded(){
        health -= 1;
    }
    
}
