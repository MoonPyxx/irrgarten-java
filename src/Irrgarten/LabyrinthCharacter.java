package Irrgarten;

public abstract class LabyrinthCharacter {
    private String name;
    private float intelligence, strength, health;
    private int row, col;
    
    
 public LabyrinthCharacter(String name, float intelligence, float strength, float health){
    this.name = name;
    this.intelligence = intelligence;
    this.strength = strength;
    this.health = health;
 }
 public LabyrinthCharacter(LabyrinthCharacter other){
     this.name = other.name;
     this.intelligence = other.intelligence;
     this.strength = other.strength;
     this.health = other.health;
     this.row = other.row;
     this.col = other.col;
 }
    public Boolean dead (){
        return health <= 0;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    protected float getIntelligence(){
        return intelligence;
    }
    protected float getStrength(){
        return strength;
    }
    protected float getHealth(){
        return health;
    }
    protected String getName(){
        return name;
    }
    protected void setHealth(float health){
        this.health = health;
    }
    public void setPos(int row, int col){
        this.row = row;
        this.col = col;
    }
    public String toString() {
        return "LabyrinthCharacter [Name: " + getName() + 
               ", Intelligence: " + getIntelligence() + 
               ", Strength: " + getStrength() + 
               ", Health: " + getHealth() + 
               ", Row: " + getRow() + 
               ", Col: " + getCol() + "]";
    }
    protected void gotWounded(){
        health -= 1;
    }
    public abstract float attack();
    public abstract Boolean defend(float attack);
}
