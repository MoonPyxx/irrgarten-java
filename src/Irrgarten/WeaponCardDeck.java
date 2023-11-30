package Irrgarten;
public class WeaponCardDeck extends CardDeck<Weapon> {
    @Override
    public void addCards() {
        float power = Dice.weaponPower();
        int uses = Dice.usesLeft(); 
        Weapon weapon = new Weapon(power,uses);
        addCard(weapon); 
    }
}