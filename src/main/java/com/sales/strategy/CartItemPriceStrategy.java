package com.sales.strategy;

import java.math.BigDecimal;

public interface CartItemPriceStrategy {
    BigDecimal calculateSalesTax();
}
