package com.sales.strategy;

import java.math.BigDecimal;

public class TaxExemptAndNotImportItemStrategy implements CartItemPriceStrategy {
    public TaxExemptAndNotImportItemStrategy(BigDecimal price) {
    }

    @Override
    public BigDecimal calculateSalesTax() {
        return BigDecimal.ZERO;
    }
}
