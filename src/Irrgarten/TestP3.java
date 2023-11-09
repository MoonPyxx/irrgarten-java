package Irrgarten;
public class TestP3 {
    public static void main(String[] args) {

    Player p1 = new Player('3', 0.2f, 0.6f);
        System.out.println("Antes del bucle for: " + p1.toString());
        for (int i=0; i<3; i++){
            System.out.println("Dentro del bucle for, iteracion: " + i);
            p1.receiveReward();
            System.out.println("Despues de receiveReward: " + p1.toString());
        }
        }
}
