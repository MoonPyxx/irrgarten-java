package Irrgarten;

import java.util.ArrayList;
        
public class Game {
    private static int MAX_ROUNDS  = 10;
    private int currentPlayerIndex;
    private String log;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Monster> monsters = new ArrayList<>();
    private Labyrinth labyrinth;
    
    
    public Game (int nPlayers, boolean debug){
        log = "";
        if(debug){
            for (int i=0; i < nPlayers; i++){   
            float intelligence = i+1;
            float strength = i+2;
            players.add(new Player((char)(i + '0'), intelligence, strength));
        }   
            currentPlayerIndex = 1;
            labyrinth = new Labyrinth(10,10,8,8);
            configureLabyrinthDebug();
        } else{
            
        for (int i=0; i < nPlayers; i++){
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
        
    }
    public boolean finished(){
        return labyrinth.haveAWinner();
    }
    public boolean nextStep(Directions preferredDirection){
        log = "";
        Player currentPlayer = players.get(currentPlayerIndex);
        boolean dead = currentPlayer.dead();
        if (!dead){
            Directions direction = actualDirection(preferredDirection);
            if (direction != preferredDirection){
                logPlayerNoOrders();
            }
            Monster monster = labyrinth.putPlayer(direction, currentPlayer);
            if (monster == null){
                logNoMonster();
            } else {
                GameCharacter winner = combat(monster);
                manageReward(winner);
            }
        } else {
            manageResurrection();
        }
        boolean endGame = finished();
        if (!endGame){
            nextPlayer();
        } 
        return endGame;
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
        int numBlocks = 5;
            for (int i = 0; i < numBlocks; i++) {
                int row = Dice.randomPos(10);
                int col = Dice.randomPos(10);
                int length = 2;
                labyrinth.addBlock(Orientation.VERTICAL, row, col ,length);
            }
        int numMonsters = 5;
            for (int i = 0; i < numMonsters; i++) {
                int row = Dice.randomPos(10);
                int col = Dice.randomPos(10);
                
                String monsterName = "Monster " + (i+1);
                float intelligence = Dice.randomIntelligence();
                float strength = Dice.randomStrength();
                
                Monster m = new Monster(monsterName, intelligence, strength);
                m.setPos(row,col);
                labyrinth.addMonster(row,col, m);
                monsters.add(m);
            }
            labyrinth.spreadPlayers(players);
                    
    }
    private void configureLabyrinthDebug(){
        int numBlocks = 5, numMonsters = 5;
            for (int i = 0; i < numBlocks; i++) {
                int row = i+1;
                int col = i+1; 
                int length = 2;
                labyrinth.addBlock(Orientation.VERTICAL, row, col ,length);
         }
        for (int i = 0; i<numMonsters; i++){
            int row = i;
            int col = i;      
            String monsterName = "Monster " + (i+1);
            float intelligence = i+1;
            float strength = i+1;
            Monster m = new Monster(monsterName, intelligence, strength);
            m.setPos(row, col);
            labyrinth.addMonster(i+1,i+1, m);
             monsters.add(m);
        }
        labyrinth.spreadPlayersDebug(players);
    }
    private void nextPlayer(){
        currentPlayerIndex++;
        if (currentPlayerIndex >= players.size()){
            currentPlayerIndex= 0;
        }
    }
    private Directions actualDirection(Directions preferredDirection){
        Player currentPlayer = players.get(currentPlayerIndex);
        int currentRow = currentPlayer.getRow();
        int currentCol = currentPlayer.getCol();
        Directions [] validMoves = labyrinth.validMoves(currentRow, currentCol);
        Directions output = currentPlayer.move(preferredDirection, validMoves);
        return output;
    }
    private GameCharacter combat(Monster monster){
        Player currentPlayer = players.get(currentPlayerIndex);
        int rounds = 0;
        GameCharacter winner = GameCharacter.PLAYER;
        boolean lose = false;
        while (!lose && rounds < MAX_ROUNDS){
           float playerAttack = currentPlayer.attack(); 
           lose = monster.defend(playerAttack);
           if (!lose){
               float monsterAttack = monster.attack();
               lose = currentPlayer.defend(monsterAttack);
               if (lose){
                   winner = GameCharacter.MONSTER;
               }
           }
           rounds ++;
        }
        logRounds(rounds, MAX_ROUNDS);
        return winner;
        
    }
    private void manageReward(GameCharacter winner){
        Player currentPlayer = players.get(currentPlayerIndex);
        if (winner == GameCharacter.PLAYER){
            currentPlayer.receiveReward();
            logPlayerWon();
        } else{
            logMonsterWon();
        }
    }
    private void manageResurrection(){
        Player currentPlayer = players.get(currentPlayerIndex);
        boolean resurrect = Dice.resurrectPlayer();
        if (resurrect){
            currentPlayer.resurrect();
            logResurrected();
        } else{
            logPlayerSkipTurn();
        }
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
    // getters temporal
    public Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }
    public Labyrinth getLabyrinth(){
        return labyrinth;
    } 
}
