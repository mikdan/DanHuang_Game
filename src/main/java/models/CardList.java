package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardList {
	
	protected List<Card> cards;
	
	public CardList(){
		cards= new ArrayList<Card>();	
	}
	
	public List<Card> getCards() {
		return cards;
	}
	

	public void addCards(Card card){
		this.cards.add(card);
	}
	
	 public void removeAllCards() {
	       cards= new ArrayList<Card>();
	 }
	 
	public Card getCardRandom(){
		int cardRandom;
		cardRandom= new Random().nextInt(cards.size()-1);
		Card card=cards.get(cardRandom);
		cards.remove(cardRandom);
		return card;
	}
	
	public Card getLastCard(){
		Card card=cards.get(cards.size()-1);
		return card;
		
	}
	
	public void removeLastCard(){
		cards.remove(cards.size()-1);
	}
	
	public boolean isEmpty() {
        return this.cards.isEmpty();
    }
	
	public String listCards(List<Card> list) {
        String cList = "";
        for (Card card : list) {
            cList=cList+card;
        }
        return cList;
    }
	
}
