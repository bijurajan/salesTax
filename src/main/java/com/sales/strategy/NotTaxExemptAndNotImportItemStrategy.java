package com.sales.strategy;

import com.sales.util.PriceFormatUtil;

import java.math.BigDecimal;

public class NotTaxExemptAndNotImportItemStrategy implements CartItemPriceStrategy {
    private final BigDecimal price;
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    private static final BigDecimal BASIC_SALES_TAX = BigDecimal.TEN;

    public NotTaxExemptAndNotImportItemStrategy(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal calculateSalesTax() {
        return PriceFormatUtil.roundToNext2Decimal(price.multiply(BASIC_SALES_TAX).divide(HUNDRED));
    }
}
