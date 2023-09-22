package Irrgarten;
public class TestP1 {
    public static void main(String[] args){
        Weapon sword = new Weapon(5.0f, 3);
        Shield shield = new Shield(4.0f, 2);
        
        Directions direction = Directions.LEFT;
        GameCharacter character = GameCharacter.PLAYER;
        int resurrectCount = 0;
        for (int i = 0; i < 100; i++) {
            if (Dice.resurrectPlayer()) {
                resurrectCount++;
            }
        }
        System.out.println("Número de resurrecciones: " + resurrectCount);
    }
    
}
