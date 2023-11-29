package Irrgarten;

public class Monster extends LabyrinthCharacter {
    private static int INITIAL_HEALTH  = 5;
    
    public Monster (String name, float intelligence, float strength){
        super(name,intelligence,strength,INITIAL_HEALTH);
    }
    @Override
    public float attack(){
        return Dice.intensity(getStrength());
    }
    @Override
    public Boolean defend(float receivedAttack){
        if (dead()){
            return false;
        }
        float defensiveEnergy = Dice.intensity(getIntelligence());
             if (defensiveEnergy < receivedAttack){
                 gotWounded();
                 return dead();
        }
             return false;
        } 
    @Override
    public String toString(){
        return super.toString();
    }
}
