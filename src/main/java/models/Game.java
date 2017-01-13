package models;

import java.util.HashMap;
import java.util.Map;

public class Game {
	private  CardDeck deck;
	private  Discard discard;
	private  Map<CardSuit, Foundation> founs;
	private  Map<Integer, CardStack> stack;
	private static final int STACK_COUNT=7;
	private static final int FOUND_COUNT=4;
	public Game() {
		deck = new CardDeck();
		discard = new Discard();
		founs = new HashMap<CardSuit, Foundation>();
		stack = new HashMap<Integer, CardStack>();
		initial();
	}
	
	

	public static int getStackCount() {
		return STACK_COUNT;
	}




	public static int getFoundCount() {
		return FOUND_COUNT;
	}




	private void initial() {
		// TODO Auto-generated method stub
		for(CardSuit suit : CardSuit.values()){
			founs.put(suit, new Foundation());
		}
		for(int i=1; i<=STACK_COUNT;i++){
			stack.put(i, new CardStack(i));
		}
	}



	public CardDeck getDeck() {
		return deck;
	}



	public void setDeck(CardDeck deck) {
		this.deck = deck;
	}



	public Discard getDiscard() {
		return discard;
	}



	public void setDiscard(Discard discard) {
		this.discard = discard;
	}


	public Map<CardSuit, Foundation> getFouns() {
		return founs;
	}



	public void setFouns(Map<CardSuit, Foundation> founs) {
		this.founs = founs;
	}



	public Map<Integer, CardStack> getStack() {
		return stack;
	}



	public void setStack(Map<Integer, CardStack> stack) {
		this.stack = stack;
	}

	public Foundation getFoundation(CardSuit card) {
		return founs.get(card);
	}
	    
	public CardStack getCardStack(int pos){
		return stack.get(pos);
	    	
	} 
	
	
}
