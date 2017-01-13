package controllers;

import java.util.Map;

import models.Card;
import models.CardStack;
import models.CardSuit;
import models.Foundation;
import utils.IO;
public class MoveFoundToStackController {
	private Map<CardSuit, Foundation> found;
	private Map<Integer, CardStack> stack;
	private IO io;
	private int numStack;
	private int numFound;
	
	

	public MoveFoundToStackController(Map<CardSuit, Foundation> map, Map<Integer, CardStack> map2) {
		super();
		this.found = map;
		this.stack = map2;
		io = new IO();
	}





	public int getNumStack() {
		return numStack;
	}



	public void setNumStack(int numStack) {
		this.numStack = numStack;
	}



	public int getNumFound() {
		return numFound;
	}



	public void setNumFound(int numFound) {
		this.numFound = numFound;
	}



	public void exec(){
		Foundation foundation = found.get(numFound);
		if(!foundation.isEmpty()){
			Card foundCard = foundation.getLastCard();
			CardStack cStack = stack.get(numStack);
			if(!cStack.isEmpty()){
				Card cardStack = cStack.getLastCardUnhidden();
				if(cardStack.isNextCardNumber(foundCard)){
					cStack.putCardUnhidden(foundCard);
					foundation.removeLastCard();	
				}else{
					io.writeln("ERROR!!! No se puede poner "+foundCard + " sobre " + cardStack);
				}
			}else if(cStack.getCardUnhidden().isEmpty()) {
				 io.writeln("ERROR!!! Falta la carta para voltear");
			}else{
				cStack.putCardUnhidden(foundCard);
				foundation.removeLastCard();
			}
		}else{
			io.writeln("ERROR!!! No hay carta para mover a escalera");
		}
	}
}
