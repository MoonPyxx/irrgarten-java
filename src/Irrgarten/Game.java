package Irrgarten;

import java.util.ArrayList;
        
public class Game {
    private static int MAX_ROUNDS  = 10;
    private int currentPlayerIndex;
    private String log;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Monster> monsters = new ArrayList<>();
    private Labyrinth labyrinth;
    
    
    public Game (int nPlayers){
        for (int i=1; i <= nPlayers; i++){
            float intelligence = Dice.randomIntelligence();
            float strength = Dice.randomStrength();
            players.add(new Player((char)(i + '0'), intelligence, strength));
            
        }
        currentPlayerIndex = Dice.whoStarts(nPlayers);
        int exitRow = Dice.randomPos(10);
        int exitCol = Dice.randomPos(10);
        labyrinth = new Labyrinth(10, 10, exitRow, exitCol);
        configureLabyrinth();
    }
    public boolean finished(){
        return labyrinth.haveAWinner();
        
    }
    public boolean nextStep(Directions preferredDirection){
        return false;
    }
    public GameState getGameState(){
        String labyrinthString = labyrinth.toString();
     String playersString = "";
    for (Player p : players) {
        playersString += p.toString() + "\n";
    }
        String monstersString = "";
        for (Monster m : monsters){
            monstersString += m.toString() + "\n";
        }
        boolean isWinner  = finished();
        return new GameState(labyrinthString, playersString, monstersString, currentPlayerIndex, isWinner, log);
    }
    private void configureLabyrinth(){
            for (int i = 0; i < 5; i++) {
                int row = Dice.randomPos(10);
                int col = Dice.randomPos(10);
                
                String monsterName = "Monster " + (i+1);
                float intelligence = Dice.randomIntelligence();
                float strength = Dice.randomStrength();
                
                Monster m = new Monster(monsterName, intelligence, strength);
                labyrinth.addMonster(row,col, m);
                monsters.add(m);
            }
                    
    }
    private void nextPlayer(){
        currentPlayerIndex++;
        if (currentPlayerIndex >= players.size()){
            currentPlayerIndex= 0;
        }
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
        log += "The player has won the combat.\n";
    }
    private void logMonsterWon(){
        log += "The monster has won the combat.\n";

    }
    private void logResurrected(){
        log += "The player has resurrected.\n";

    }
    private void logPlayerSkipTurn(){
        log += "The player has skipped the turn due to being dead.\n";
   
    }
    private void logPlayerNoOrders(){
        log += "The player did not follow the human player's instructions.\n";
 
    }
    private void logNoMonster(){
        log += "The player moved to an empty cell or couldn't move.\n";

    }
    private void logRounds(int rounds, int max){
       log += rounds + " out of " + max + " combat rounds have occurred.\n";

    }
}
