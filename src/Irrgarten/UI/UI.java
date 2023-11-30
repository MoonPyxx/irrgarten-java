package Irrgarten.UI;
import Irrgarten.Directions;
import Irrgarten.GameState;
public interface UI {
    public Directions nextMove();
    public void showGame(GameState gameState);
}
