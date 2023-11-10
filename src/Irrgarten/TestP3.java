package Irrgarten;
import Irrgarten.UI.TextUI;
public class TestP3 {
    public static void main(String[] args) {

        Game game = new Game(2);
        TextUI vista = new TextUI();
        vista.showGame(game.getGameState());
        
        
}
}
