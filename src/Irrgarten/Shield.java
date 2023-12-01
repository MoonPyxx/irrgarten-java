package Irrgarten;

public class Shield extends CombatElement{
    private float protection;
    private int uses;
    public Shield(float protection, int uses){
        super(protection,uses);
        this.protection = protection;
        this.uses = uses;
    }
    public float protect(){
        return produceEffect();
    }
    @Override
    public String toString(){
        return "S[Protection: "+ protection + ", uses: " + uses + "]";
    }
}
