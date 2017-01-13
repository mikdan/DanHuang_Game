package controllers;

import java.util.List;

import java.util.Map;

import models.Card;
import models.CardStack;
import utils.IO;
public class MoveStackToStackController {
	private Map<Integer, CardStack> stack;
	private IO io;
	
	
	private int fromStack;
	private int toStack;
	private int nmCards;
	
	
	
	public MoveStackToStackController(Map<Integer, CardStack> map) {
		super();
		this.stack = map;
		io = new IO();
	}
	
	
	public int getFromStack() {
		return fromStack;
	}



	public void setFromStack(int fromStack) {
		this.fromStack = fromStack;
	}



	public int getToStack() {
		return toStack;
	}



	public void setToStack(int toStack) {
		this.toStack = toStack;
	}

 

	public int getNmCards() {
		return nmCards;
	}



	public void setNmCards(int nmCards) {
		this.nmCards = nmCards;
	}



	public void exec(){
		CardStack fStack = stack.get(fromStack);
		CardStack tStack = stack.get(toStack);
		int numberCards=fStack.getCardUnhidden().size();
		int manyCards = numberCards-nmCards;
		List <Card> fromList = fStack.getCardUnhidden().subList(manyCards, numberCards);
		Card fCard = fromList.get(0);
		if(!fStack.isEmpty()){
		
			if(!tStack.isEmpty()){
				Card cardTo = tStack.getLastCardUnhidden();
				if(cardTo.isNextCardNumber(fCard)){
					tStack.getCardUnhidden().addAll(fromList);
					fStack.getCardUnhidden().removeAll(fromList);
					
				}else{
					io.writeln("ERROR!!! No se puede mover la carta en escalera a escala");
				}
				
			}else{
				tStack.getCardUnhidden().addAll(fromList);
				fStack.getCardUnhidden().removeAll(fromList);
			}
		}else{
	 
			io.writeln("ERROR!!! La escalera es vacía");
		}
		
		
	}

	
}
