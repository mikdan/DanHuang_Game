package models;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import models.Card;
import models.CardNumber;
import models.CardSuit;
import models.Discard;
public class DiscardTest {
	private Discard discard;
	private Card cardBastos;
	private Card cardOros;
	private Card cardEspadas;
	
	@Before
	public void initial(){
		discard= new Discard();
	}

	@Test
	public void toStringTest() {
		assertEquals("<vacío>", discard.toString());
		
		cardBastos = new Card(CardNumber.ACE, CardSuit.bastos);
		discard.addCards(cardBastos);
		cardOros = new Card(CardNumber.KING, CardSuit.oros);
		discard.addCards(cardOros);
		cardEspadas = new Card(CardNumber.EIGHT, CardSuit.espadas);
		discard.addCards(cardEspadas);
		assertEquals(cardBastos.toString() + cardOros.toString() + cardEspadas.toString(), discard.toString());
		
	}

}
