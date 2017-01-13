package models;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class CardNumberTest {
    @Test
    public void getValueTest() {
        assertEquals("A", CardNumber.ACE.getCardNumber());
        assertEquals("3", CardNumber.THREE.getCardNumber());
        assertEquals("8", CardNumber.EIGHT.getCardNumber());
    }

    @Test
    public void nextTest() {
        assertEquals(CardNumber.TWO, CardNumber.ACE.next());
        assertEquals(CardNumber.SIX, CardNumber.FIVE.next());
        assertEquals(CardNumber.KING, CardNumber.QUEEN.next());
    }
}
