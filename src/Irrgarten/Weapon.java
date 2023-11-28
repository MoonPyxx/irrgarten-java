package Irrgarten;

public class Weapon extends CombatElement{
    private float power;
    private int uses;
    
    
    public Weapon(float power, int uses){
        super(power,uses);
    }
    public float attack(){
        return produceEffect();
    }
    @Override
    public String toString(){
        return "W[Power: " + power + ", uses: " + uses + "]";
    }
}