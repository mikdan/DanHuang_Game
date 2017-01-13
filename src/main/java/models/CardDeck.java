package models;

import java.util.Collections;

public class CardDeck extends CardList{

	public CardDeck() {
		super();
		// TODO Auto-generated constructor stub
		CardSuit[] suits = CardSuit.values();
        CardNumber[] numbers = CardNumber.values();
        for (CardNumber cardNumber : numbers) {
            for (CardSuit cardSuit : suits) {
            	Card card = new Card(cardNumber,cardSuit);
                super.cards.add(card); 
            }
        }
        Collections.shuffle(super.cards);
	}
	
	
	

	
	@Override
	public String toString() {
		if(!super.cards.isEmpty()){
			return "[X,X]";
		}
		else
			return "<vacío>";
		 
	}
	
}

