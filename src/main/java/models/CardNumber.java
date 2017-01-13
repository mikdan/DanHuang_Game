package models;

public enum CardNumber {
	ACE("A"),
	TWO("2"),
	THREE("3"),
	FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    JACK("J"),
    QUEEN("Q"),
    KING("K");	
	
	private String cardNumber;	
	private CardNumber(String cardNumber){
		this.cardNumber=cardNumber;
	}
	public String getCardNumber() {
		return cardNumber;
	}	
	
	public boolean isAce(){
        return this.ordinal() == ACE.ordinal();
    }
	
	public boolean isKing(){
        return this.ordinal() == KING.ordinal();
    }
	public CardNumber next() {
		CardNumber[] numbers = values();
        return numbers[(this.ordinal() + 1) % numbers.length];
	}

}
