package Irrgarten;

import java.util.ArrayList;
        
public class Game {
    private static int MAX_ROUNDS  = 10;
    private int currentPlayerIndex;
    private String log;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Monster> monsters = new ArrayList<>();
    private Labyrinth labyrinth;
    private Player currentPlayer;
    
    
    public Game (int nPlayers, boolean debug){
        
        if(debug){
            log = "";
            for (int i=0; i < nPlayers; i++){   
            float intelligence = 5;
            float strength = 5;
            players.add(new Player((char)(i + '0'), intelligence, strength));
        }   
            currentPlayerIndex = 0;
            labyrinth = new Labyrinth(10,10,9,9);
            configureLabyrinthDebug();
        } else{
            log = "";
        for (int i=0; i < nPlayers; i++){
            float intelligence = Dice.randomIntelligence();
            float strength = Dice.randomStrength();
            players.add(new Player((char)(i + '0'), intelligence, strength));
        }
        currentPlayerIndex = Dice.whoStarts(nPlayers);
        currentPlayer= players.get(currentPlayerIndex);
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
        int numBlocks = 2, numMonsters = 2;
            for (int i = 0; i < numBlocks; i++) {
                int row = i+1;
                int col = i+1; 
                int length = 2;
                labyrinth.addBlock(Orientation.VERTICAL, row, col ,length);
         }
        Monster m1 = new Monster("Monster 1", 10,10);
        Monster m2 = new Monster("Monster 2", 6,6);
        labyrinth.addMonster(5,5,m1);
        monsters.add(m1);
        m1.setPos(5,5);
        labyrinth.addMonster(6,6,m2);
        monsters.add(m2);
        m2.setPos(6,6);
        labyrinth.spreadPlayersDebug(players);
    }
    private void nextPlayer(){
        currentPlayerIndex++;
        if (currentPlayerIndex >= players.size()){
            currentPlayerIndex= 0;
        }
    }
    private Directions actualDirection(Directions preferredDirection){
        int currentRow = currentPlayer.getRow();
        int currentCol = currentPlayer.getCol();
        Directions [] validMoves = labyrinth.validMoves(currentRow, currentCol);
        return currentPlayer.move(preferredDirection, validMoves);
    }
    private GameCharacter combat(Monster monster){
        
        int rounds = 0;
        GameCharacter winner = GameCharacter.PLAYER;
        float playerAttack = currentPlayer.attack();
        boolean lose = monster.defend(playerAttack);
        while (!lose && (rounds < MAX_ROUNDS)){
            winner = GameCharacter.MONSTER;
            rounds++;
            float monsterAttack = monster.attack();
            lose = currentPlayer.defend(monsterAttack);
            if (!lose){
                playerAttack = currentPlayer.attack();
                lose = monster.defend(playerAttack);
                winner = GameCharacter.PLAYER;
            }
        }
        logRounds(rounds, MAX_ROUNDS);
        return winner;

        
        // codigo antiguo
        /*
        int rounds = 0;
        GameCharacter winner = GameCharacter.PLAYER;
        boolean lose = false;
        while (!lose && rounds < MAX_ROUNDS){
           float playerAttack = currentPlayer.attack(); 
           lose = monster.defend(playerAttack);
           if (!lose){
               float modnsterAttack = monster.attack();
               lose = currentPlayer.defend(monsterAttack);
               if (lose){
                   winner = GameCharacter.MONSTER;
               }
           }
           rounds ++;
        }
        logRounds(rounds, MAX_ROUNDS);
*/
        
    }
    private void manageReward(GameCharacter winner){
        if (winner == GameCharacter.PLAYER){
            currentPlayer.receiveReward();
            logPlayerWon();
        } else{
            logMonsterWon();
        }
    }
    private void manageResurrection(){
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
}
