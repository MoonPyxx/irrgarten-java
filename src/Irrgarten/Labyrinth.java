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

    
    public void spreadPlayers(ArrayList <Player> players){
        for (Player p : players){
            int [] pos = randomEmptyPos();
            putPlayer2D(-1, -1, pos[0], pos[1], p); // oldRow = -1 oldCol = -1 
        }
    }
    public void spreadPlayersDebug(ArrayList <Player> players){
        Player player0 = players.get(0);
        Player player1 = players.get(1);
        putPlayer2D(-1, -1, 5, 6, player0);
        putPlayer2D(-1, -1, 6, 5, player1);
              
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
        int oldRow = player.getRow();
        int oldCol = player.getCol();
        int [] newPos = dir2Pos(oldRow, oldCol, direction);
        Monster monster = putPlayer2D(oldRow, oldCol, newPos[ROW], newPos[COL], player);
        return monster;
     }
    public void addBlock(Orientation orientation, int startRow, int startCol, int length){
        int incRow = 0;
        int incCol = 0;
        if (orientation == Orientation.VERTICAL){
            incRow = 1;
        } else{
            incCol = 1;
        }
        int row = startRow;
        int col = startCol;
        
        while (posOK(row,col) && emptyPos(row,col) && length > 0){
            labyrinth[row][col]= BLOCK_CHAR;
            row += incRow;
            col += incCol;
            length--;
        }
    }
            
    public Directions[] validMoves(int row, int col){
       ArrayList<Directions> output = new ArrayList<>();
       if (canStepOn(row+1, col)){
           output.add(Directions.DOWN);
       }
       if (canStepOn(row-1, col)){
           output.add(Directions.UP);
       }
       if (canStepOn(row, col+1)){
           output.add(Directions.RIGHT);
       }
       if (canStepOn(row, col-1)){
           output.add(Directions.LEFT);
       }
       return output.toArray(new Directions[output.size()]);
    }
    private boolean posOK (int row, int col){
        return row >=0 && row < nRows && col >= 0 && col < nCols;
    }
    private boolean emptyPos(int row, int col){
        if (!posOK(row, col)){
        return false;
        }
        return labyrinth[row][col] == EMPTY_CHAR && players[row][col] == null && monsters[row][col] == null;
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
     public Monster putPlayer2D(int oldRow, int oldCol, int row, int col, Player player){
         Monster output = null;
         if (canStepOn(row,col)){
             if (posOK(oldRow, oldCol)){
                 Player p = players[oldRow][oldCol];
                 if (p == player){
                     updateOldPos(oldRow, oldCol);
                     players[oldRow][oldCol] = null;
                 }
             }
             boolean monsterPos = monsterPos(row, col);
             if (monsterPos){
                 labyrinth[row][col] = COMBAT_CHAR;
                 output = monsters[row][col];
             } else{
                char number = player.getNumber();
                labyrinth[row][col] = number;
             }
             players[row][col] = player;
             player.setPos(row, col);
         }
         return output;
     }
}
