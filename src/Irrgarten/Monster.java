
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
    }
    public boolean dead(){
        return false;
    }
    public float attack(){
        return 0.0f;
    }
    public boolean defend(float receivedAttack){
        return false;
    }
    public void setPost(int row, int col){
        
    }
    public String toString(){
        return null;
    }
    public void gotWounded(){
        
    }
    
}
