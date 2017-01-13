package models;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.Card;
import models.CardNumber;
import models.CardSuit;
public class CardTest {
	
	private Card cardBastos;
	private Card cardOros;
	private Card cardEspadas;
	
	@Before
	public void initial(){
		cardBastos = new Card(CardNumber.ACE, CardSuit.bastos);
		cardOros = new Card(CardNumber.KING, CardSuit.oros);
		cardEspadas = new Card(CardNumber.EIGHT, CardSuit.espadas);
		
	}
	
	@Test
    public void getCardNumberTest() {
        assertEquals(CardNumber.ACE, cardBastos.getCardNumber());
        assertEquals(CardNumber.KING, cardOros.getCardNumber());
        assertEquals(CardNumber.EIGHT, cardEspadas.getCardNumber());
    }
	
	@Test
    public void getCardSuitTest() {
        assertEquals(CardSuit.bastos, cardBastos.getCardSuit());
        assertEquals(CardSuit.oros, cardOros.getCardSuit());
        assertEquals(CardSuit.espadas, cardEspadas.getCardSuit());
    }
	

	@Test
	public void toStringTest() {
		assertEquals("[A,b]", cardBastos.toString());
        assertEquals("[K,o]", cardOros.toString());
        assertEquals("[8,e]", cardEspadas.toString());
	}

}
