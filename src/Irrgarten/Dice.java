package Irrgarten;
import java.util.Random;
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
}