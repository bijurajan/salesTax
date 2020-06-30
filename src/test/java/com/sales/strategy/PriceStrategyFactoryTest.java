package com.sales.strategy;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PriceStrategyFactoryTest {

    private static BigDecimal SOME_PRICE = BigDecimal.valueOf(12.34);

    @Test
    public void shouldReturnValidStrategyForTaxExemptNotImported() {
        boolean isExempt = true;
        boolean isImported = false;

        var result = PriceStrategyFactory.getStrategy(SOME_PRICE, isExempt, isImported);

        assertThat(result.getClass(), equalTo(TaxExemptAndNotImportItemStrategy.class));
    }

    @Test
    public void shouldReturnValidStrategyForTaxExemptImported() {
        boolean isExempt = true;
        boolean isImported = true;

        var result = PriceStrategyFactory.getStrategy(SOME_PRICE, isExempt, isImported);

        assertThat(result.getClass(), equalTo(TaxExemptAndImportItemStrategy.class));
    }

    @Test
    public void shouldReturnValidStrategyForNotTaxExemptNotImported() {
        boolean isExempt = false;
        boolean isImported = false;

        var result = PriceStrategyFactory.getStrategy(SOME_PRICE, isExempt, isImported);

        assertThat(result.getClass(), equalTo(NotTaxExemptAndNotImportItemStrategy.class));
    }

    @Test
    public void shouldReturnRightStrategyForNotTaxExemptImported() {
        boolean exempt = false;
        boolean imported = true;

        var result = PriceStrategyFactory.getStrategy(SOME_PRICE, exempt, imported);

        assertThat(result.getClass(), equalTo(NotTaxExemptAndImportItemStrategy.class));
    }
}