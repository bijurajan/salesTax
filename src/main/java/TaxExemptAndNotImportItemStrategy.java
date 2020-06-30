import java.math.BigDecimal;

public class TaxExemptAndNotImportItemStrategy implements CartItemPriceStrategy{
    private BigDecimal price;

    public TaxExemptAndNotImportItemStrategy(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal calculateSalesTax() {
        return BigDecimal.ZERO;
    }
}
