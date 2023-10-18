package Irrgarten;

import java.util.ArrayList;
        
public class Game {
    private static int MAX_ROUNDS  = 10;
    private int currentPlayerIndex;
    private String log;
    private ArrayList<Player> players = new ArrayList<>();
    private Labyrinth labyrinth;
    
    
    public Game (int nPlayers){
        for (int i=0; i< nPlayers; i++){
            players.add(new Player());
        }
        labyrinth = new Labyrinth();
    }
    public boolean finished(){
        return labyrinth.haveAWinner();
        
    }
    public boolean nextStep(Directions preferredDirection){
        return false;
    }
    public GameState getGameState(){
        return new GameState();
    }
    private void configureLabyrinth(){
        
    }
    private void nextPlayer(){
        
    }
    private Directions actualDirection(Directions preferredDirection){
        return null;
    }
    private GameCharacter combat(Monster monster){
        return null;
    }
    private void manageReward(GameCharacter winner){
        
    }
    private void manageResurrection(){
        
    }
    private void logPlayerWon(){
        
    }
    private void logMonsterWon(){
        
    }
    private void logResurrected(){
        
    }
    private void logPlayerSkipTurn(){
        
    }
    private void logPlayerNoOrders(){
        
    }
    private void logNoMonster(){
        
    }
    private void logRounds(int rounds, int max){
        
    }
}
