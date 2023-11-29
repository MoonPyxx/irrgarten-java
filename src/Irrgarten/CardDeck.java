package Irrgarten;
import java.util.ArrayList;
import java.util.Collections;
public abstract class CardDeck<T> {
    private ArrayList<T> cardDeck;
    public CardDeck(){
        
    }
    protected abstract void addCards();
    protected void addCard(T card){
        cardDeck.add(card);
    }
    public T nextCard(){
        if (cardDeck.isEmpty()){
            addCards();
            Collections.shuffle(cardDeck);
        }
        return cardDeck.remove(0);
    }
}
