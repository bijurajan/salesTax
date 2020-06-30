package com.sales.strategy;

import java.math.BigDecimal;

public class PriceStrategyFactory {

    private PriceStrategyFactory() {

    }

    public static CartItemPriceStrategy getStrategy(BigDecimal price, boolean exempt, boolean imported) {
        if (exempt && imported) {
            return new TaxExemptAndImportItemStrategy(price);
        }
        if (exempt) {
            return new TaxExemptAndNotImportItemStrategy(price);
        }
        if (imported) {
            return new NotTaxExemptAndImportItemStrategy(price);
        }
        return new NotTaxExemptAndNotImportItemStrategy(price);
    }
}
