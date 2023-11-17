package Irrgarten;
import Irrgarten.UI.TextUI;
import Irrgarten.controller.Controller;
public class mainController {
    public static void main(String[] args) {
        Game game = new Game(5,false);
        TextUI vista = new TextUI();
        Controller c = new Controller(game,vista);
        c.play();   
}
}
