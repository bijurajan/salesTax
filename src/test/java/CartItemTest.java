import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartItemTest {

    private CartItem cartItem;

    @Before
    public void setUp() {
        cartItem = new CartItem();
    }

    @Test
    public void calculatePriceWithTaxShouldNotAddAnyBasicTaxOnExemptItems() {
        Item exemptItem = new Item("Exempt Item", true);
        BigDecimal price = new BigDecimal(100);

        BigDecimal result = cartItem.calculatePriceWithTax(exemptItem, price);

        assertThat(result, equalTo(new BigDecimal("100.00")));
    }

    @Test
    public void calculatePriceWithTaxShouldAddBasicTaxOnNonExemptItems() {
        Item exemptItem = new Item("Non Exempt Item", false);
        BigDecimal price = new BigDecimal(100);

        BigDecimal result = cartItem.calculatePriceWithTax(exemptItem, price);

        assertThat(result, equalTo(new BigDecimal("105.00")));
    }
}