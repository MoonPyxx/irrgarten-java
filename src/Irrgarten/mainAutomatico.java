package Irrgarten;
import Irrgarten.UI.TextUI;
public class mainAutomatico {
    public static void main(String[] args) {

        Game game = new Game(2,true);
        TextUI view = new TextUI();
        // Probar combates
        game.nextStep(Directions.LEFT);
        view.showGame(game.getGameState());
        game.nextStep(Directions.RIGHT);
        view.showGame(game.getGameState());      
        
    }
}
