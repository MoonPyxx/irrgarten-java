package Irrgarten;
public class ShieldCardDeck extends CardDeck<Shield> {
    @Override
    public void addCards() {
        for (int i = 0; i < MAX_SHIELDS; i++) {
            addCard(new Shield();
        }
    }
}