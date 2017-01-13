package models;

public enum CardSuit {
	
	oros('o'),
	copas('c'),
	espadas('e'),
	bastos('b');
	private char cardSuit;
	
	private CardSuit(char cardSuit){
		this.cardSuit=cardSuit;
	}	

	 
	public char getCardSuit() {
		return cardSuit;
	}


	public String toString(){
		return ""+cardSuit;
	}


	public int position() {
		return this.ordinal() + 1;
	}
}
