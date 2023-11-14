package Irrgarten;
import Irrgarten.UI.TextUI;
import Irrgarten.controller.Controller;
public class TestP3 {
    public static void main(String[] args) {

        Game game = new Game(2,false);
        TextUI vista = new TextUI();
        Controller c = new Controller(game,vista);
        c.play();
}
}
