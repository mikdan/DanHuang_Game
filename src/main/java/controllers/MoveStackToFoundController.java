package controllers;

import java.util.Map;

import models.Card;
import models.CardStack;
import models.CardSuit;
import models.Foundation;
import utils.IO;
public class MoveStackToFoundController {
	private Map<Integer, CardStack> stack;
	private Map<CardSuit, Foundation> found;
	private IO io;
	private int numStack;
	
	
	
	public MoveStackToFoundController(Map<Integer, CardStack> stack, Map<CardSuit, Foundation> map) {
		super();
		this.stack = stack;
		this.found = map;
		io = new IO();
	}


	


	public int getNumStack() {
		return numStack;
	}




	public void setNumStack(int numStack) {
		this.numStack = numStack;
	}




	public void exec(){
		CardStack cStack = stack.get(numStack);
		if(!cStack.isEmpty()){
			Card stackCard = cStack.getLastCardUnhidden();
			Foundation foundation = found.get(stackCard.getCardSuit());
			if(!foundation.isEmpty()){
				Card cardFound = foundation.getLastCard();
				if(stackCard.isNextCardNumber(cardFound)){
					foundation.addCards(stackCard);
					cStack.removeLastCardHidden();
				}else{
					io.writeln("ERROR!!! No se puede poner " + cStack + "sobre" + cardFound);
				}
			}else{
				if(stackCard.getCardNumber().isAce()){
					foundation.addCards(stackCard);
					cStack.removeLastCardUnhidden();
					
				}else{
					io.writeln("ERROR!!! La carta que no es ACE no se puede poner en palo vacío ");
				}
			}
		}else{
			io.writeln("ERROR!!! La escalera es vacía");
		}
	}

}
