package com.sales.model;

import com.sales.strategy.*;

import java.math.BigDecimal;

public class CartItem {
    private final BigDecimal price;
    private CartItemPriceStrategy priceStrategy;

    public CartItem(Item item, BigDecimal price) {
        this.price = price;
        this.priceStrategy = PriceStrategyFactory.getStrategy(price, item.isExempt(), item.isImported());
    }

    public BigDecimal calculatePriceWithTax() {
        return this.price.add(calculateSalesTax());
    }

    public BigDecimal calculateSalesTax() {
        return this.priceStrategy.calculateSalesTax();
    }
}
