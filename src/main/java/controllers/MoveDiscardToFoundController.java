package controllers;
import java.util.Map;

import models.Card;
import models.CardSuit;
import models.Discard;
import models.Foundation;
import utils.IO;
public class MoveDiscardToFoundController {
	private Map<CardSuit, Foundation> found;
	private Discard discard;
	private IO io;
	

	public MoveDiscardToFoundController(Map<CardSuit, Foundation> map, Discard discard) {
		super();
		this.found = map;
		this.discard = discard;
		io = new IO();
	}



	public void exec(){
		if(!discard.isEmpty()){
			//int numFoun=io.readInt("A qué Escalera? [1-7]:");
			Card discardCard=discard.getLastCard();
 
			Foundation foundation = found.get(discardCard.getCardSuit());
			if(!foundation.isEmpty()){
				Card foundCard = foundation.getLastCard();
				if(discardCard.isNextCardNumber(foundCard)){
					foundation.addCards(discardCard);
					discard.removeLastCard();
				}else{
					io.writeln("ERROR!!! No se puede colocar sobre la carta que no es orden");
				}
		 
			}else{
				if(discardCard.getCardNumber().isAce()){
					foundation.addCards(discardCard);
					discard.removeLastCard();
				}else{
					io.writeln("ERROR!!! No se puede colocar en el orden que no hay ACE");
				}
			}
		
			
			
		}else{
			io.writeln("ERROR!!! No hay carta para mover a palo");
		}
		
	}
}
