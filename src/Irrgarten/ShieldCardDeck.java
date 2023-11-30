package Irrgarten;
public class ShieldCardDeck extends CardDeck<Shield> {
    @Override
    public void addCards() {
        float protection = Dice.shieldPower(); 
        int uses = Dice.usesLeft(); 
        Shield shield = new Shield(protection,uses);
        addCard(shield);  
    }
}