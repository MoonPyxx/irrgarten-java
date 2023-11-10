package Irrgarten;
public class GameState {
   private String labyrinth;
   private String players;
   private String monsters;
   private int currentPlayer;
   private boolean winner;
   private String log;
   
   public GameState(String labyrinth, String players, String monsters, int currentPlayer, boolean winner, String log){
       this.labyrinth = labyrinth;
       this.players = players;
       this.monsters = monsters;
       this.currentPlayer = currentPlayer;
       this.winner = winner;
       this.log = log;
   }
   // Este getter es para comprobar
   public String getLabyrinth(){
       return labyrinth;
   }
   
}

