import java.math.BigDecimal;
import java.math.RoundingMode;

public class CartItem {
    public static final BigDecimal BASIC_SALES_TAX = BigDecimal.TEN;
    private final Item item;
    private final BigDecimal price;

    public CartItem(Item item, BigDecimal price) {
        this.item = item;
        this.price = price;
    }

    public BigDecimal calculatePriceWithTax() {
        if(item.isExempt()){
            return price.setScale(2, RoundingMode.HALF_UP);
        }
        BigDecimal multiplicand = new BigDecimal("1.05");
        return price.multiply(multiplicand).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateSalesTax() {
        if(item.isExempt()){
            return BigDecimal.ZERO;
        }
        return price.multiply(BASIC_SALES_TAX)
                .divide(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
