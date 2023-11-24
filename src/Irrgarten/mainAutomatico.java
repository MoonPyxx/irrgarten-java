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
        
        // Comprobar si resucitar funciona
        Player muerto = game.getCurrentPlayer();
        muerto.setHealth(0);
        for (int i=0; i<10; i++)
        {
            game.nextStep(Directions.LEFT);
            view.showGame(game.getGameState());
        }
          // comprobar a mover a un jugador a una posición concreta
         game.getLabyrinth().putPlayer2D(game.getCurrentPlayer().getRow(), game.getCurrentPlayer().getCol() , 9, 6, game.getCurrentPlayer());
        view.showGame(game.getGameState());

        
        
    }
}
