import java.math.BigDecimal;
import java.math.RoundingMode;

public class NotTaxExemptAndImportItemStrategy implements CartItemPriceStrategy{
    private final BigDecimal price;
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    private static final BigDecimal IMPORT_DUTY = BigDecimal.valueOf(5);
    private static final BigDecimal BASIC_SALES_TAX = BigDecimal.TEN;

    public NotTaxExemptAndImportItemStrategy(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal calculateSalesTax() {
        BigDecimal basicSalesTax = addTax(BASIC_SALES_TAX);
        BigDecimal importDuty = addTax(IMPORT_DUTY);
        return basicSalesTax.add(importDuty);
    }

    private BigDecimal addTax(BigDecimal tax) {
        return roundToNext2Decimal(price.multiply(tax).divide(HUNDRED));
    }

    private BigDecimal roundToNext2Decimal(BigDecimal price) {
        return price.divide(new BigDecimal(5)).setScale(2,
                RoundingMode.UP).multiply(new BigDecimal(5));
    }
}
