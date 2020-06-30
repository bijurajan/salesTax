import java.math.BigDecimal;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> cartItems;

    public ShoppingCart(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public String calculateSalesTax() {
        return this.cartItems.stream().map(CartItem::calculateSalesTax)
                .reduce(BigDecimal.ZERO, BigDecimal::add).toString();
    }

    public String calculateTotal() {
        return this.cartItems.stream().map(CartItem::calculatePriceWithTax)
                .reduce(BigDecimal.ZERO, BigDecimal::add).toString();
    }
}
