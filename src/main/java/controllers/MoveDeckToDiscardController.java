package controllers;

import models.Card;
import models.CardDeck;
import models.Discard;
import utils.IO;
public class MoveDeckToDiscardController {
	private CardDeck cardDeck;
	private Discard discard;	
	private IO io;
	private static final int NumMaxDiscard = 3;

	
	public MoveDeckToDiscardController(CardDeck cardDeck, Discard discard) {
		super();
		this.cardDeck = cardDeck;
		this.discard = discard;
		io = new IO();
	}

	
	public void exec(){
       
		if(!cardDeck.isEmpty()){
			for(int i=0;i<NumMaxDiscard;i++){
				
			Card card;
			card=cardDeck.getCards().get(0);
			cardDeck.getCards().remove(0);
			discard.addCards(card);
			
			}
		}else{
			io.writeln("ERROR!!! La baraja está vacía");
		}
			
	} 
	
}
