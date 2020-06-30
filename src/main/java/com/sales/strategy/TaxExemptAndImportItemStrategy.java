package com.sales.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxExemptAndImportItemStrategy implements CartItemPriceStrategy {
    private final BigDecimal price;
    private static final BigDecimal IMPORT_DUTY = BigDecimal.valueOf(5);
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);

    public TaxExemptAndImportItemStrategy(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal calculateSalesTax() {
        return roundToNext2Decimal(price.multiply(IMPORT_DUTY).divide(HUNDRED));
    }

    private BigDecimal roundToNext2Decimal(BigDecimal price) {
        return price.divide(new BigDecimal(5)).setScale(2,
                RoundingMode.UP).multiply(new BigDecimal(5));
    }
}
