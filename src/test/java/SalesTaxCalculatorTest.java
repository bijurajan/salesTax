import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SalesTaxCalculatorTest {

    private SalesTaxCalculator salesTaxCalculator;

    @Before
    public void setUp() {
        salesTaxCalculator = new SalesTaxCalculator();
    }

    @Test
    public void shouldAddOnlyImportTaxOnExemptItems() {
        Item exemptItem = new Item("Exempt Item", true);
        BigDecimal price = new BigDecimal(100);

        BigDecimal result = salesTaxCalculator.calculateTaxForItem(exemptItem, price);

        assertThat(result, equalTo(new BigDecimal("105.00")));
    }
}