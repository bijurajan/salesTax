package com.sales.strategy;

import com.sales.util.PriceFormatUtil;

import java.math.BigDecimal;

public class NotTaxExemptAndImportItemStrategy implements CartItemPriceStrategy {
    private final BigDecimal price;
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    private static final BigDecimal IMPORT_DUTY = BigDecimal.valueOf(5);
    private static final BigDecimal BASIC_SALES_TAX = BigDecimal.TEN;

    public NotTaxExemptAndImportItemStrategy(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal calculateSalesTax() {
        BigDecimal basicSalesTax = computeTax(BASIC_SALES_TAX);
        BigDecimal importDuty = computeTax(IMPORT_DUTY);
        return basicSalesTax.add(importDuty);
    }

    private BigDecimal computeTax(BigDecimal tax) {
        return PriceFormatUtil.roundToNext2Decimal(price.multiply(tax).divide(HUNDRED));
    }
}
