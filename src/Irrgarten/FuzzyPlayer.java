    package Irrgarten;
    import java.util.ArrayList;
    public class FuzzyPlayer extends Player {
        public FuzzyPlayer(Player other){
            super(other);
        }
        @Override
        public Directions move(Directions direction, Directions[] validMoves){
            return Dice.nextStep(direction, validMoves, this.getIntelligence());
        }
        @Override
        public float attack(){
        return sumWeapons() + Dice.intensity(this.getStrength());

        }
        @Override
        protected float defensiveEnergy(){
        return sumShields() + Dice.intensity(this.getIntelligence());
        }
        @Override
        public String toString(){
            return "Fuzzy " + super.toString();
        }
    }
