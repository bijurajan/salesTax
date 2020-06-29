import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesTaxCalculator {
    public BigDecimal calculateTaxForItem(Item exempt_item, BigDecimal price) {
        BigDecimal multiplicand = new BigDecimal("1.05");
        return price.multiply(multiplicand).setScale(2, RoundingMode.HALF_UP);
    }
}
