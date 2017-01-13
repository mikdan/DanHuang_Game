package models;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.Card;
import models.CardNumber;
import models.CardSuit;
import models.Foundation;


public class FundationTest {
	
	private Foundation found;
	
	@Before
	public void initial(){
		found= new Foundation();
		
	}

	@Test
	public void test() {
		 assertEquals("<vacío>", found.toString());
	     found.addCards(new Card(CardNumber.ACE, CardSuit.bastos));
	     found.addCards(new Card(CardNumber.TWO, CardSuit.oros));
	     found.addCards(new Card(CardNumber.THREE, CardSuit.espadas));
	     Card lastCard = new Card(CardNumber.FOUR, CardSuit.copas);
	     found.addCards(lastCard);;
	     assertEquals(lastCard.toString(), found.toString());
	}

}
