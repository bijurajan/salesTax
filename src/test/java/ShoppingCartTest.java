import com.sales.model.CartItem;
import com.sales.model.Item;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingCartTest {

    /*
    Input 1:
        1 book at 12.49
        1 music CD at 14.99
        1 chocolate bar at 0.85

     Output 1:
        1 book : 12.49
        1 music CD: 16.49
        1 chocolate bar: 0.85
        Sales Taxes: 1.50
        Total: 29.83
     */
    @Test
    public void input1ValidationTest() {
        List<CartItem> cartItems = Arrays.asList(
                new CartItem(new Item("book", true, false),
                        BigDecimal.valueOf(12.49)),
                new CartItem(new Item("music CD", false, false),
                        BigDecimal.valueOf(14.99)),
                new CartItem(new Item("chocolate bar", true, false),
                        BigDecimal.valueOf(0.85))
        );
        ShoppingCart shoppingCart = new ShoppingCart(cartItems);

        assertThat(shoppingCart.calculateSalesTax(), equalTo("1.50"));
        assertThat(shoppingCart.calculateTotal(), equalTo("29.83"));
    }

    /*
    Input 2:
        1 imported box of chocolates at 10.00
        1 imported bottle of perfume at 47.50
    Output 2:
        1 imported box of chocolates: 10.50
        1 imported bottle of perfume: 54.65
        Sales Taxes: 7.65
        Total: 65.15
     */
    @Test
    public void input2ValidationTest() {
        List<CartItem> cartItems = Arrays.asList(
                new CartItem(new Item("imported box of chocolates", true, true),
                        BigDecimal.valueOf(10.00)),
                new CartItem(new Item("imported bottle of perfume", false, true),
                        BigDecimal.valueOf(47.50))
        );
        ShoppingCart shoppingCart = new ShoppingCart(cartItems);

        assertThat(shoppingCart.calculateSalesTax(), equalTo("7.65"));
        assertThat(shoppingCart.calculateTotal(), equalTo("65.15"));
    }

    /*
    Input 3:
        1 imported bottle of perfume at 27.99
        1 bottle of perfume at 18.99
        1 packet of headache pills at 9.75
        1 box of imported chocolates at 11.25
    Output 3:
        1 imported bottle of perfume: 32.19
        1 bottle of perfume: 20.89
        1 packet of headache pills: 9.75
        1 imported box of chocolates: 11.85
        Sales Taxes: 6.70
        Total: 74.68
    */
    @Test
    public void input3ValidationTest() {
        List<CartItem> cartItems = Arrays.asList(
                new CartItem(new Item("imported bottle of perfume", false, true),
                        BigDecimal.valueOf(27.99)),
                new CartItem(new Item("bottle of perfume", false, false),
                        BigDecimal.valueOf(18.99)),
                new CartItem(new Item("packet of headache pills", true, false),
                        BigDecimal.valueOf(9.75)),
                new CartItem(new Item("box of imported chocolates", true, true),
                        BigDecimal.valueOf(11.25))
        );
        ShoppingCart shoppingCart = new ShoppingCart(cartItems);

        assertThat(shoppingCart.calculateSalesTax(), equalTo("6.70"));
        assertThat(shoppingCart.calculateTotal(), equalTo("74.68"));
    }
}
