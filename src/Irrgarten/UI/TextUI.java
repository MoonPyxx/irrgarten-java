package Irrgarten.UI;

import Irrgarten.Directions;
import Irrgarten.GameState;
import java.util.Scanner;


public class TextUI {
    
    private static Scanner in = new Scanner(System.in);
    
    private char readChar() {
        String s = in.nextLine();     
        return s.charAt(0);
    }
    

    public Directions nextMove() {
        System.out.print("Where? ");
        
        Directions direction = Directions.DOWN;
        boolean gotInput = false;
        
        while (!gotInput) {
            char c = readChar();
            switch(c) {
                case 'w':
                    System.out.print(" UP\n");
                    direction = Directions.UP;
                    gotInput = true;
                    break;
                case 's':
                    System.out.print(" DOWN\n");
                    direction = Directions.DOWN;
                    gotInput = true;
                    break;
                case 'd':
                    System.out.print("RIGHT\n");
                    direction = Directions.RIGHT;
                    gotInput = true;
                    break;
                case 'a':
                    System.out.print(" LEFT\n");
                    direction = Directions.LEFT;
                    gotInput = true;    
                    break;
            }
        }    
        return direction;
    }
    
    public void showGame(GameState gameState) {
        System.out.println("Labyrinth:\n " + gameState.getLabyrinth());
        System.out.println("Players:\n" + gameState.getPlayers());
        System.out.println("Monsters:\n" + gameState.getMonsters());
        System.out.println("Log:\n" + gameState.getLog()); 
        System.out.println("Current player: " + gameState.getCurrentPlayer());
        System.out.println("Winner: " + gameState.getWinner());
    }
    
}
