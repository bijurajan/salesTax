package com.sales.util;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PriceFormatUtilTest {

    @Test
    public void shouldRoundUpTo2DecimalsToNeared005For2DigitsAfter() {
        var result = PriceFormatUtil.roundToNext2Decimal(BigDecimal.valueOf(1.26));

        assertThat(result.toString(), equalTo("1.30"));
    }

    @Test
    public void shouldRoundUpTo2DecimalsToNeared005ForMultipleDigitsAfter() {
        var result = PriceFormatUtil.roundToNext2Decimal(BigDecimal.valueOf(1.24999));

        assertThat(result.toString(), equalTo("1.25"));
    }

    @Test
    public void shouldRoundUpTo2DecimalsToNeared005ForOneDigitAfter() {
        var result = PriceFormatUtil.roundToNext2Decimal(BigDecimal.valueOf(1.2));

        assertThat(result.toString(), equalTo("1.20"));
    }
}
