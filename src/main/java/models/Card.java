package models;

public class Card{
	
	private CardNumber cardNumber;
	private CardSuit cardSuit;
	public Card(CardNumber cardNumber, CardSuit cardSuit){
		this.cardNumber=cardNumber;
		this.cardSuit=cardSuit;
	}
	public CardNumber getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(CardNumber cardNumber) {
		this.cardNumber = cardNumber;
	}
	public CardSuit getCardSuit() {
		return cardSuit;
	}
	public void setCardSuit(CardSuit cardSuit) {
		this.cardSuit = cardSuit;
	}
	
	@Override
	public String toString() {
		return "[" + cardNumber.getCardNumber() +"," + cardSuit + "]";
	}
	public boolean isNextCardNumber(Card foundCard) {
		return (cardNumber==foundCard.getCardNumber().next());
	}
	
	

}
