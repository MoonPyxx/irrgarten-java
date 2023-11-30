package Irrgarten;
public class ShieldCardDeck extends CardDeck<Shield> {
    private static int MAX_SHIELDS = 3; // Preguntar
    @Override
    public void addCards() {
        for (int i = 0; i < MAX_SHIELDS; i++) {
        float protection = Dice.shieldPower(); 
        int uses = Dice.usesLeft(); 
        Shield shield = new Shield(protection,uses);
        addCard(shield); 
        }
    }
}