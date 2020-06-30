import java.math.BigDecimal;
import java.math.RoundingMode;

public class CartItem {
    private final Item item;
    private final BigDecimal price;
    private CartItemPriceStrategy priceStrategy;

    public CartItem(Item item, BigDecimal price) {
        this.item = item;
        this.price = price;
        if (item.isExempt() && !item.isImported()) {
            this.priceStrategy = new TaxExemptAndNotImportItemStrategy(price);
        }
        if (item.isExempt() && item.isImported()) {
            this.priceStrategy = new TaxExemptAndImportItemStrategy(price);
        }
        if (!item.isExempt() && item.isImported()) {
            this.priceStrategy = new NotTaxExemptAndImportItemStrategy(price);
        }
        if (!item.isExempt() && !item.isImported()) {
            this.priceStrategy = new NotTaxExemptAndNotImportItemStrategy(price);
        }
    }

    public BigDecimal calculatePriceWithTax() {
        if (item.isExempt()) {
            return price.setScale(2, RoundingMode.HALF_UP);
        }
        BigDecimal multiplicand = new BigDecimal("1.05");
        return price.multiply(multiplicand).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateSalesTax() {
        return this.priceStrategy.calculateSalesTax();
    }
}
