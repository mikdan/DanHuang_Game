package controllers;

import java.util.Map;

import models.CardStack;
import utils.IO;

public class FlipInFoundController {
	private Map<Integer, CardStack> stack;
	private IO io;
	private int numStack;
	
	public FlipInFoundController(Map<Integer, CardStack> map) {
		super();
		this.stack = map;
		io = new IO();
	}

	public void exec(){
		CardStack cardStack = stack.get(numStack);
		if(!cardStack.isEmpty()){
			io.writeln("ERROR!!! La carta es volteada");
		}else if(cardStack.getCardUnhidden().isEmpty()){
			cardStack.flipLastCardHidden();
		}else{
			io.writeln("ERROR!!! La escalera es vacía");	
		}
	}
 
	public int getNumStack() {
		return numStack;
	}

	public void setNumStack(int numStack) {
		this.numStack = numStack;
	}
}
