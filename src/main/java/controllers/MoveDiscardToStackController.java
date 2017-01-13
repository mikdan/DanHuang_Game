package controllers;

import java.util.Map;

import models.Card;
import models.CardStack;
import models.Discard;
import models.Game;
import utils.IO;
public class MoveDiscardToStackController {
	private Discard discard;
	private Map<Integer, CardStack> stack;
	private IO io;
	private int numStack;
	
	
	
	public MoveDiscardToStackController(Discard discard, Map<Integer, CardStack> stack) {
		super();
		this.discard = discard;
		this.stack = stack;
		io = new IO();
	}





	public int getNumStack() {
		return numStack;
	}



	public void setNumStack(int numStack) {
		this.numStack = numStack;
	}



	public void exec(){
	
		if(discard.isEmpty()){
			io.writeln("No hay carta para mover a escalera");
			return;

		}
		int numStack = io.readInt("A qué escalera? [1-7]:");
			Card discardCard = discard.getLastCard();
			CardStack cStack = stack.get(numStack);
			Card stackCard = cStack.getLastCardUnhidden();
			 
			if(numStack>Game.getStackCount()){
				return;
				 
			}
			io.writeln("Escalera no hay ");
			if(!cStack.isEmpty()){
						
				if(numStack < Game.getStackCount()){
					if(stackCard.isNextCardNumber(discardCard)){
						cStack.putCardUnhidden(discardCard);
						discard.removeLastCard();
						
					}else{
						 
						io.writeln("ERROR!!!No se puede poner " + discardCard + " sobre "+ stackCard);
					}
				}else{
					io.writeln("Escalera no hay ");
				}
				
			}else{
				if(stackCard.getCardNumber().isKing()){
					cStack.putCardUnhidden(discardCard);
					discard.removeLastCard();
				}else{
					io.writeln("ERROR!!! No se puede colocar en el orden que no sea KING");
				}
				 
			}
		
	}
}
