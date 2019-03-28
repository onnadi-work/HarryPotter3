import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {

    public static final int BOOK_PRICE = 8;

    @Test
    public void testBasketOfSingleTypeOfBook(){
        Basket basket = new Basket(1);
        assertEquals(BOOK_PRICE, basket.price(), 0.001);

        basket = new Basket(2);
        assertEquals(16, basket.price(), 0.001);
    }

    @Test
    public void testBasketOfOneOfEachTypeOfBook(){
        Basket basket = new Basket(1, 1);
        assertEquals(BOOK_PRICE * 2 * 0.95, basket.price(), 0.001);

        basket = new Basket(1, 1, 1);
        assertEquals(BOOK_PRICE * 3 * 0.9, basket.price(), 0.001);

        basket = new Basket(1, 1, 1, 1);
        assertEquals(BOOK_PRICE * 4 * 0.8, basket.price(), 0.001);

        basket = new Basket(1, 1, 1, 1, 1);
        assertEquals(BOOK_PRICE * 5 * 0.75, basket.price(), 0.001);
    }

    @Test
    public void testBasketOfDifferentNumbersOfBooks(){
        Basket basket = new Basket(2, 1, 1);
        assertEquals(BOOK_PRICE + (BOOK_PRICE * 3 * 0.9), basket.price(), 0.001);

        basket = new Basket(2 , 2, 2, 1, 1);
        assertEquals((BOOK_PRICE * 4 * 0.8) + (BOOK_PRICE * 4 * 0.8), basket.price(), 0.001);

        basket = new Basket(2, 2, 3, 1, 1);
        assertEquals(BOOK_PRICE + (BOOK_PRICE * 4 * 0.8) + (BOOK_PRICE * 4 * 0.8), basket.price(), 0.001);

        basket = new Basket(5, 5, 4, 5, 4);
        assertEquals(4*(BOOK_PRICE * 5 * 0.75) + (BOOK_PRICE * 3 * 0.9), basket.price(), 0.001);
    }
}