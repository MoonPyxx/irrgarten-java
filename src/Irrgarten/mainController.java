package Irrgarten;
import Irrgarten.UI.GuiUI;
import Irrgarten.controller.Controller;
public class mainController {
    public static void main(String[] args) {
        Game game = new Game(2,false);
        GuiUI vista = new GuiUI();
        Controller c = new Controller(game,vista);
        c.play();   
}
}

