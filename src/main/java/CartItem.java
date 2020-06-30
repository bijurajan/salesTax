import java.math.BigDecimal;

public class CartItem {
    private final BigDecimal price;
    private CartItemPriceStrategy priceStrategy;

    public CartItem(Item item, BigDecimal price) {
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
        return this.price.add(calculateSalesTax());
    }

    public BigDecimal calculateSalesTax() {
        return this.priceStrategy.calculateSalesTax();
    }
}
