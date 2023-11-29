package Irrgarten;
import java.util.Random;
import java.util.ArrayList;
public class Dice{
    //Atributos de clase
    private static final int MAX_USES = 5;
    private static final float MAX_INTELLIGENCE = 10.0f;
    private static final float MAX_STRENGTH = 10.0f;
    private static final float RESURRECT_PROB = 0.3f;
    private static final int WEAPONS_REWARD = 2;
    private static final int SHIELDS_REWARD = 3;
    private static final int HEALTH_REWARD = 5;
    private static final int MAX_ATTACK = 3;
    private static final int MAX_SHIELD = 2;
    private static Random generator = new Random();
    
    
    // Metodos de clase publicos
    
    public static int randomPos(int max){
        return generator.nextInt(max);
    }
    public static int whoStarts(int nplayers){
        return generator.nextInt(nplayers);
    }
    public static float randomIntelligence(){
        return generator.nextFloat() * MAX_INTELLIGENCE;
    }
    public static float randomStrength(){
        return generator.nextFloat() * MAX_STRENGTH;
    }
    public static boolean resurrectPlayer(){
        return generator.nextFloat() < RESURRECT_PROB;
    }
    public static int weaponsReward(){
        return generator.nextInt(WEAPONS_REWARD + 1);
    }
    public static int shieldsReward(){
        return generator.nextInt(SHIELDS_REWARD + 1);
    }
    public static int healthReward(){
        return generator.nextInt(HEALTH_REWARD + 1);
    }
    public static float weaponPower(){
        return generator.nextFloat() * MAX_ATTACK;
    }
    public static float shieldPower(){
        return generator.nextFloat() * MAX_SHIELD;
    }
    public static int usesLeft(){
        return generator.nextInt(MAX_USES + 1);
    }
    public static float intensity(float competence){
        return generator.nextFloat() * competence;
    }
    public static boolean discardElement(int usesLeft){
        if (usesLeft == MAX_USES){
            return false;
        } else if (usesLeft == 0){
            return true;
        } else {
            float probability = 1.0f - ((float)usesLeft / MAX_USES);
            return generator.nextFloat() < probability;
        }
    }
    // Practica 4
    public static Directions nextStep(Directions preference, ArrayList<Directions> validMoves, float intelligence){
        if (generator.nextFloat() < (intelligence / MAX_INTELLIGENCE)){
            return preference;
        } else{
            return validMoves.get(generator.nextInt(validMoves.size()));
        }
    }
}