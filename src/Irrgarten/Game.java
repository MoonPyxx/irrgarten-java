package Irrgarten;

public class Game {
    private static int MAX_ROUNDS  = 10;
    private int currentPlayerIndex;
    private String log;
    
    
    public Game (int nPlayers){
        
    }
    public boolean finished(){
        return false;
    }
    public boolean nextStep(Directions preferredDirection){
        return false;
    }
    public GameState getGameState(){
        return null;
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
