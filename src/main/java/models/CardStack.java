package models;

import java.util.ArrayList;
import java.util.List;

public class CardStack {
	private List<Card> cardHidden;
	private List<Card> cardUnhidden;
	public CardStack() {
		this.cardHidden = new ArrayList<Card>();
		this.cardUnhidden = new ArrayList<Card>();
	}
	

	public CardStack(int pos){
		this.cardHidden = new ArrayList<Card>();
		int i=0;
		while(i<pos-1){
			Card card=new CardDeck().getCardRandom();
			this.cardHidden.add(card);
			i++;	
		}
		this.cardUnhidden = new ArrayList<Card>();
		Card card = new CardDeck().getCardRandom();
		this.cardUnhidden.add(card);
	}
	public List<Card> getCardHidden() {
		return cardHidden;
	}
	public void setCardHidden(List<Card> cardHidden) {
		this.cardHidden = cardHidden;
	}
	public List<Card> getCardUnhidden() {
		return cardUnhidden;
	}
	public void setCardUnhide(List<Card> cardUnhidden) {
		this.cardUnhidden = cardUnhidden;
	}
	
	
	public Card getLastCardHidden(){
		if(cardHidden.size()!=0){
			Card card=cardHidden.get(cardHidden.size()-1);
			return card;
		}else{
			return null;
		}	 
	}
	
	public Card getLastCardUnhidden(){
		if(cardUnhidden.size()!=0){
			Card card=cardUnhidden.get(cardUnhidden.size()-1);
			return card;
		}else{
			return null;
		}	 
	}
	
	public void putCardUnhidden(Card card){
		this.cardUnhidden.add(card);
	}
	
	public void removeLastCardHidden(){
		this.cardHidden.remove(cardHidden.size()-1);
	}
    
	public void removeLastCardUnhidden(){
		this.cardUnhidden.remove(cardUnhidden.size()-1);
	}
	
	public List<Card> getAll(){
		List<Card> cards = new ArrayList<Card>();
		cards.addAll(cardHidden);
		cards.addAll(cardUnhidden);
		return cards;
	}
	
	public boolean isEmpty(){
		return this.getAll().isEmpty();
	}
	
	public void flipLastCardHidden(){
		Card card=getLastCardHidden();
		putCardUnhidden(card);
		removeLastCardUnhidden();
		
	}

	@Override
	public String toString() {
		if( cardHidden.isEmpty() && cardUnhidden.isEmpty()){
			return "<vacío>";
			
		}else{
			String cHidden="";
			int i=0;
			while(i<cardHidden.size()){
				cHidden=cHidden+"[";
				i++;
			}
			
			String cUnhidden="";
			for(Card cdUnhidden : cardUnhidden){
				cHidden=cHidden+cdUnhidden;
			}
			return cHidden + cUnhidden;
		}
	}
		
}
