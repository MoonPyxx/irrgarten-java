package Irrgarten;
import Irrgarten.UI.TextUI;
public class TestP3 {
    public static void main(String[] args) {

        Game game = new Game(4);
        TextUI vista = new TextUI();
        vista.showGame(game.getGameState());
        game.nextStep(Directions.DOWN);
        vista.showGame(game.getGameState());

        
        
}
}
