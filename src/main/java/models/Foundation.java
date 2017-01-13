package models;

public class Foundation extends CardList {
	 

	public Foundation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if(!super.cards.isEmpty()){
			return cards.get(super.cards.size()-1).toString();
		}else
			return "<vacío>";
	}	
}
