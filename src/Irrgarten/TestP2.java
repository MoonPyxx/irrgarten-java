/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Irrgarten;


public class TestP2 {
    public static void main(String[] args){
    // Creacion juego
        Game game = new Game(3);
        
        // Estado inicial
        GameState initialState = game.getGameState();
        
        System.out.println("Labyrinth:\n" + initialState.getLabyrinth());
        System.out.println("Players:\n" + initialState.getPlayers());
        System.out.println("Monsters:\n" + initialState.getMonsters());
        System.out.println("Current Player: " + initialState.getCurrentPlayer());
        System.out.println("Winner: " + initialState.getWinner());
        System.out.println("Log:\n" + initialState.getLog());

        

        while (!game.finished()) {
            // Imprimir estado despues de cada turno
            GameState currentState = game.getGameState();
            System.out.println("Labyrinth:\n" + currentState.getLabyrinth());
            System.out.println("Players:\n" + currentState.getPlayers());
            System.out.println("Monsters:\n" + currentState.getMonsters());
            System.out.println("Current Player: " + currentState.getCurrentPlayer());
            System.out.println("Winner: " + currentState.getWinner());
            System.out.println("Log:\n" + currentState.getLog());
        }
        
        System.out.println("Game over!");
    }
   
}
