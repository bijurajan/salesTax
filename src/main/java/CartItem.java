import java.math.BigDecimal;
import java.math.RoundingMode;

public class CartItem {
    public BigDecimal calculatePriceWithTax(Item item, BigDecimal price) {
        if(item.isExempt()){
            return price.setScale(2, RoundingMode.HALF_UP);
        }
        BigDecimal multiplicand = new BigDecimal("1.05");
        return price.multiply(multiplicand).setScale(2, RoundingMode.HALF_UP);
    }
}
