import java.math.BigDecimal;
import java.math.RoundingMode;

public class NotTaxExemptAndNotImportItemStrategy implements CartItemPriceStrategy{
    private final BigDecimal price;
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    private static final BigDecimal BASIC_SALES_TAX = BigDecimal.TEN;

    public NotTaxExemptAndNotImportItemStrategy(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal calculateSalesTax() {
        return addTax(BASIC_SALES_TAX);
    }

    private BigDecimal addTax(BigDecimal salesTax) {
        return roundToNext2Decimal(price.multiply(salesTax).divide(HUNDRED));
    }

    private BigDecimal roundToNext2Decimal(BigDecimal price) {
        return price.divide(new BigDecimal(5)).setScale(2,
                RoundingMode.UP).multiply(new BigDecimal(5));
    }
}
