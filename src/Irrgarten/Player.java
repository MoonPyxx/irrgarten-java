package Irrgarten;

import java.util.ArrayList;

public class Player extends LabyrinthCharacter {
    private static int MAX_WEAPONS = 2;
    private static int MAX_SHIELDS = 3;
    private static int INITIAL_HEALTH = 10;
    private static int HITS2LOSE = 3;
    private char number;
    private int consecutiveHits=0;
    
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<Shield> shields = new ArrayList<>();
    private ShieldCardDeck shieldCardDeck;
    private WeaponCardDeck weaponCardDeck;


    

    
    public Player(char number, float intelligence, float strength){
        super("Player # " + number,intelligence,strength,INITIAL_HEALTH);
        shieldCardDeck= new ShieldCardDeck();
        weaponCardDeck= new WeaponCardDeck();
        this.number = number;
    }
    public Player(Player other){
        super(other.getName(),other.getIntelligence(), other.getStrength(), other.getHealth());
    }
    public void resurrect(){
        weapons.clear();
        shields.clear();    
        setHealth(INITIAL_HEALTH);
        consecutiveHits = 0;
    }
    public Directions move(Directions direction, Directions[] validMoves){
        int size = validMoves.length;
        boolean contained = false;
        
        for (Directions d: validMoves){
            if (d == direction){
                contained = true;
                break;
            }
        }
        if (size > 0 && !contained){
            return validMoves[0];
        } else {
            return direction;
        }
    }
    public char getNumber(){
        return number;
    }
    @Override
    public float attack(){
        return getStrength() + sumWeapons();
    }
    @Override
    public Boolean defend(float receivedAttack){
        return manageHit(receivedAttack);
    }
    public void receiveReward(){
        int wReward = Dice.weaponsReward();
        int sReward = Dice.shieldsReward();
        System.out.println("w " + wReward);
        System.out.println("s : " + sReward);
        for (int i = 0; i < wReward; i++){
            Weapon wnew = weaponCardDeck.nextCard();
            receiveWeapon(wnew);
        }
        for (int i = 0; i < sReward; i++){
            Shield snew = shieldCardDeck.nextCard();
            receiveShield(snew);
        }
        int extraHealth = Dice.healthReward();
        setHealth(getHealth()+extraHealth);
    }
    @Override
    public String toString() {
        return "Player " + super.toString() + 
               "\nWeapons: " + weapons.toString() + 
               "\nShields: " + shields.toString() +
               " Sum Weapons: " + sumWeapons() + 
               " Sum Shields: " + sumShields();
    }
    private void receiveWeapon(Weapon w){
        for (int i = 0; i < weapons.size(); i++){
            Weapon wi = weapons.get(i);
            boolean discard = wi.discard();
            if (discard){
                weapons.remove(i);
                i--;
            }
        }
        int size = weapons.size();
        if (size < MAX_WEAPONS){
            weapons.add(w);
        }
    }
    private void receiveShield(Shield s){
        for (int i = 0; i < shields.size(); i++){
            Shield si = shields.get(i);
            boolean discard = si.discard();
            if (discard){
                shields.remove(i);
                i--;
            }
        }
        int size = shields.size();
        if (size < MAX_SHIELDS){
            shields.add(s);
        }
    }
    protected float sumWeapons(){
        float sum = 0.0f;
        for (Weapon w: weapons){
            sum += w.attack();
        }
        return sum;
    }
    protected float sumShields(){
        float sum = 0.0f;
        for (Shield s: shields){
            sum += s.protect();
        }
        return sum;
    }
    protected float defensiveEnergy(){
        return getIntelligence() + sumShields();
    }
    private boolean manageHit(float receivedAttack){
        float defense = defensiveEnergy();
        boolean lose;
        if (defense < receivedAttack){
            gotWounded();
            incConsecutiveHits();
        } else {
            resetHits();
        }
        if ((consecutiveHits == HITS2LOSE) || dead()){
            resetHits();
            lose = true;
        } else{
            lose = false;
        }
        return lose;
        
    }
    private void resetHits(){
        consecutiveHits = 0;
    }
    private void incConsecutiveHits(){
        consecutiveHits++;
    }
    
    
}