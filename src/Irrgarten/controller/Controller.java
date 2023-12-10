package Irrgarten.controller;

import Irrgarten.Directions;
import Irrgarten.Game;
import Irrgarten.UI.GuiUI;


public class Controller {
    
    private Game game;
    private GuiUI view;
    
    public Controller(Game game, GuiUI view) {
        this.game = game;
        this.view = view;
    }
    
    public void play() {
        boolean endOfGame = false;
        while (!endOfGame) {
            view.showGame(game.getGameState()); 
            Directions direction = view.nextMove(); 
            endOfGame = game.nextStep(direction);
        }
      view.showGame(game.getGameState());        
    }
    
}
