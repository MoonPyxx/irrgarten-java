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
    private Monster[][] monsters;
    private Player[][] players;
    private char[][] labyrinth;
    
    public Labyrinth(int nRows, int nCols, int exitRow, int exitCol){
     labyrinth = new char[nRows][nCols];
     monsters = new Monster[nRows][nCols];
     players = new Player[nRows][nCols];
        this.nRows = nRows;
        this.nCols = nCols;
        this.exitRow = exitRow;
        this.exitCol = exitCol;
        for (int i = 0; i<nRows; i++){
            for (int j = 0; j<nCols; j++){
                labyrinth[i][j] = EMPTY_CHAR;
                monsters[i][j] = null;
                players[i][j] = null;
            }
        }
        labyrinth[exitRow][exitCol] = EXIT_CHAR;
    }

    
    public void spreadPlayers(Player[] players){
        
    }
    public boolean haveAWinner(){
        return players[exitRow][exitCol] != null;
    }
    public String toString(){
        String result = "";
         for (int i = 0; i<nRows; i++){
            for (int j = 0; j<nCols; j++){
                if (combatPos(i,j)){
                    result += COMBAT_CHAR;
                } else if(monsterPos(i,j)){
                    result += MONSTER_CHAR;
                } else{
                     result +=labyrinth[i][j];
                }
                result += ' ';
            }
            result += "\n";
        }
         return result;
    }
    public void addMonster(int row, int col, Monster monster){
        if(canStepOn(row, col)){
            monsters[row][col]= monster;
            if (players[row][col]!= null){
                labyrinth[row][col] = COMBAT_CHAR;
            } else{
                labyrinth[row][col] = MONSTER_CHAR;
            }
        }
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
        return row >=0 && row < nRows && col >= 0 && col < nCols;
    }
    private boolean monsterPos(int row, int col){
        return monsters[row][col]!=null;
    }
    private boolean exitPos(int row, int col){
        return labyrinth[row][col]== EXIT_CHAR;
    }
     private boolean combatPos(int row, int col){
        return monsters[row][col] != null && players[row][col] != null;
    }
     private boolean canStepOn(int row, int col){
        return posOK(row, col) && (labyrinth[row][col] == EMPTY_CHAR || monsterPos(row, col) || exitPos(row, col));
    }
     private void updateOldPos(int row, int col){
         if (row >= 0 && row < nRows && col >= 0 && col < nCols) {
                if (labyrinth[row][col]== COMBAT_CHAR){
                    labyrinth[row][col]= MONSTER_CHAR;
                } else{
                    labyrinth[row][col] = EMPTY_CHAR;
                }
             
         }
     }
     private int[] dir2Pos(int row, int col, Directions direction){
         switch (direction) {
        case UP:
            row--;
            break;
        case DOWN:
            row++;
            break;
        case LEFT:
            col--;
            break;
        case RIGHT:
            col++;
            break;
    }
         return new int[]{row,col};
     }
     private int[] randomEmptyPos(){
         int randomRow, randomCol;
         do {
             randomRow = Dice.randomPos(nRows);
             randomCol = Dice.randomPos(nCols);
         } while (labyrinth[randomRow][randomCol] != EMPTY_CHAR);   
         return new int[]{randomRow, randomCol};
     }
     private Monster putPlayer2D(int oldRow, int OldCol, int row, int col, Player player){
         return null;
     }
}
