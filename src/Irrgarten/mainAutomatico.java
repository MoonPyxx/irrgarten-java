package Irrgarten;
import Irrgarten.UI.GuiUI;
import java.util.concurrent.TimeUnit;
public class mainAutomatico {
    public static void main(String[] args) throws InterruptedException {

        Game game = new Game(2,true);
        GuiUI view = new GuiUI();
        TimeUnit.SECONDS.sleep(5);
        // Probar combates
        game.nextStep(Directions.LEFT);
        view.showGame(game.getGameState());
        game.nextStep(Directions.RIGHT);
        view.showGame(game.getGameState());      
        
        // Probar resurrecion (fuzzy player)
        /*
        Player currentPlayer = game.getCurrentPlayer();
        currentPlayer.setHealth(0);
        game.nextStep(Directions.UP);
        Player currentPlayer2 = game.getCurrentPlayer();
        currentPlayer2.setHealth(0);
        view.showGame(game.getGameState());
        currentPlayer.setHealth(0);
        game.nextStep(Directions.DOWN);
        view.showGame(game.getGameState()); 

        for (int i=0; i<5;i++){
           
        game.nextStep(Directions.UP);
        view.showGame(game.getGameState());
        game.nextStep(Directions.DOWN);
        view.showGame(game.getGameState());      
         game.nextStep(Directions.DOWN);
        view.showGame(game.getGameState());   
              game.nextStep(Directions.UP);
        view.showGame(game.getGameState());
        }
*/

    }
}
