package Irrgarten;
public class WeaponCardDeck extends CardDeck<Weapon> {
    private static int MAX_WEAPONS = 2; // Preguntar
    @Override
    public void addCards() {
        for (int i = 0; i < MAX_WEAPONS; i++) {
        float power = Dice.weaponPower();
        int uses = Dice.usesLeft(); 
        Weapon weapon = new Weapon(power,uses);
        addCard(weapon ); 
        }
    }
}