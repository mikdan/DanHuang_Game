package models;

import java.util.List;

public class Discard extends CardList{

	public Discard() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if(!super.cards.isEmpty()){
			if(cards.size() > 3){
				int fIndex=super.cards.size() - 4;
				int tIndex=super.cards.size() - 1;
				List<Card> liCard=cards.subList(fIndex, tIndex);
				return listCards(liCard);
			}else{
				return listCards(cards);
				
			}
		}else {
			return "<vacío>";
		}
	}
	
}
