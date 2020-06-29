import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SalesTaxCalculatorTest {

    @Test
    public void simpleAssert() {
        BigDecimal result = new SalesTaxCalculator().calculateTax();
        assertThat(result, equalTo(BigDecimal.ZERO));
    }
}