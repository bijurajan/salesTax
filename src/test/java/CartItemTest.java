import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartItemTest {

    @Test
    public void salesTaxShouldBeZeroOnExemptItems() {
        Item exemptItem = new Item("Exempt Item", true, false);
        BigDecimal price = BigDecimal.valueOf(12.49);

        BigDecimal result = new CartItem(exemptItem, price).calculateSalesTax();

        assertThat(result, equalTo(BigDecimal.ZERO));
    }

    @Test
    public void salesTaxShouldAddBasicTaxOnNonExemptItems() {
        Item nonExemptItem = new Item("Non-Exempt Item", false, false);
        BigDecimal price = BigDecimal.valueOf(14.99);

        BigDecimal result = new CartItem(nonExemptItem, price).calculateSalesTax();

        assertThat(result, equalTo(new BigDecimal("1.50")));
    }

    @Test
    public void salesTaxShouldOnlyAddImportDutyOnExemptItems() {
        Item nonExemptItem = new Item("Exempt Item", true, true);
        BigDecimal price = BigDecimal.valueOf(10.00);

        BigDecimal result = new CartItem(nonExemptItem, price).calculateSalesTax();

        assertThat(result, equalTo(new BigDecimal("0.50")));
    }

    @Test
    public void salesTaxShouldAddBasicTaxAndImportDutyOnNonExemptItems() {
        Item nonExemptItem = new Item("Exempt Item", false, true);
        BigDecimal price = BigDecimal.valueOf(47.50);

        BigDecimal result = new CartItem(nonExemptItem, price).calculateSalesTax();

        assertThat(result, equalTo(new BigDecimal("7.15")));
    }

    @Test
    public void calculatePriceWithTaxShouldNotAddAnyBasicTaxOnExemptItems() {
        Item exemptItem = new Item("Exempt Item", true, false);
        BigDecimal price = new BigDecimal(100);

        BigDecimal result = new CartItem(exemptItem, price).calculatePriceWithTax();

        assertThat(result, equalTo(new BigDecimal("100.00")));
    }

    @Test
    public void calculatePriceWithTaxShouldAddBasicTaxOnNonExemptItems() {
        Item nonExemptItem = new Item("Non Exempt Item", false, false);
        BigDecimal price = new BigDecimal(100);

        BigDecimal result = new CartItem(nonExemptItem, price).calculatePriceWithTax();

        assertThat(result, equalTo(new BigDecimal("105.00")));
    }


}