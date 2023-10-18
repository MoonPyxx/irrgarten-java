package Irrgarten;

import java.util.ArrayList;

public class Labyrinth {
    private static char BLOCK_CHAR = 'X';
    private static char EMPTY_CHAR = '-';
    private static char MONSTER_CHAR = 'M';
    private static char COMBAT_CHAR = 'C';
    private static char EXIT_CHAR = 'E';
    private static int ROW = 0;
    private static int COL = 1;
    private int nRows, nCols, exitRow, exitCol;
    
    private ArrayList<MonsterSquare> monsterSquares = new ArrayList<>();
    private ArrayList<PlayerSquare> playerSquares = new ArrayList<>();
    private ArrayList<LabyrinthSquare> labyrinthSquares = new ArrayList<>();
    
    public Labyrinth(int nRows, int nCols, int exitRow, int exitCol){
        this.nRows = nRows;
        this.nCols = nCols;
        this.exitRow = exitRow;
        this.exitCol = exitCol;
    }
    public Labyrinth(){
        
    }
    public void spreadPlayers(Player[] players){
        
    }
    public boolean haveAWinner(){
        return false;
    }
    public String toString(){
        return null;
    }
    public void addMonster(int row, int col, Monster monster){
  
    }
    public Monster putPlayer(Directions direction, Player player){
        return null;
    }
    public void addBlock(Orientation orientation, int startRow, int startCol, int length){
        
    }
            
    public Directions[] validMoves(int row, int col){
        return null;
    }
    private boolean posOK (int row, int col){
        return false;
    }
    private boolean monsterPos(int row, int col){
        return false;
    }
    private boolean exitPos(int row, int col){
        return false;
    }
     private boolean combatPos(int row, int col){
        return false;
    }
     private boolean canStepOn(int row, int col){
        return false;
    }
     private void updateOldPos(int row, int col){
         
     }
     private int[] dir2Pos(int row, int col, Directions direction){
         return null;
     }
     private int[] randomEmptyPos(){
         return null;
     }
     private Monster putPlayer2D(int oldRow, int OldCol, int row, int col, Player player){
         return null;
     }
}
