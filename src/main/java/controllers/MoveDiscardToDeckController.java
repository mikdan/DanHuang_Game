package controllers;

import models.CardDeck;
import models.Discard;
import utils.IO;
public class MoveDiscardToDeckController {
	
	private CardDeck cardDeck;
	private Discard discard;	
	private IO io;
    
	
	public MoveDiscardToDeckController(CardDeck cardDeck, Discard discard) {
		super();
		this.cardDeck = cardDeck;
		this.discard = discard;
		io = new IO();
	}

	
	public void exec(){
		if(!cardDeck.isEmpty()){
			io.writeln("ERROR!!! La baraja está vacía");
		}else{
			cardDeck.getCards().addAll(discard.getCards());
			discard.removeAllCards();
		}
	}
}
