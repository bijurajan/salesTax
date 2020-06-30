package com.sales.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PriceFormatUtil {
    public static BigDecimal roundToNext2Decimal(BigDecimal value) {
        return value.divide(new BigDecimal(5))
                .setScale(2,RoundingMode.UP)
                .multiply(new BigDecimal(5));
    }
}
