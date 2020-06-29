import java.math.BigDecimal;
import java.math.RoundingMode;

public class CartItem {
    public static final BigDecimal BASIC_SALES_TAX = BigDecimal.TEN;
    public static final BigDecimal IMPORT_DUTY = BigDecimal.valueOf(5);
    public static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
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
            if(!item.isImported()){
                return BigDecimal.ZERO;
            }
            return addTax(price, IMPORT_DUTY);
        }
        if(item.isImported()) {
            BigDecimal basicSalesTax = addTax(price, BASIC_SALES_TAX);
            BigDecimal importDuty = addTax(price, IMPORT_DUTY);
            return basicSalesTax.add(importDuty);
        }
        return addTax(price, BASIC_SALES_TAX);
    }

    private BigDecimal addTax(BigDecimal price, BigDecimal salesTax) {
        return roundToNext2Decimal(price.multiply(salesTax).divide(HUNDRED))
    }

    private BigDecimal roundToNext2Decimal(BigDecimal price) {
        return price.divide(new BigDecimal(5)).setScale(2,
                RoundingMode.UP).multiply(new BigDecimal(5));
    }
}
