package com.sales.strategy;

import com.sales.util.PriceFormatUtil;

import java.math.BigDecimal;

public class TaxExemptAndImportItemStrategy implements CartItemPriceStrategy {
    private final BigDecimal price;
    private static final BigDecimal IMPORT_DUTY = BigDecimal.valueOf(5);
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);

    public TaxExemptAndImportItemStrategy(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal calculateSalesTax() {
        return PriceFormatUtil.roundToNext2Decimal(price.multiply(IMPORT_DUTY).divide(HUNDRED));
    }
}
