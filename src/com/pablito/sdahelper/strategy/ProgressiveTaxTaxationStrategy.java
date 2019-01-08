package com.pablito.sdahelper.strategy;

import java.math.BigDecimal;

public class ProgressiveTaxTaxationStrategy implements TaxationStrategy {
    @Override
    public BigDecimal calculateTax(final BigDecimal income) {
        if (income.compareTo(new BigDecimal(85528)) <= 0) {
            return income.multiply(new BigDecimal(18)).divide(new BigDecimal(100), 2);
        } else {
            final BigDecimal firstThreshold = new BigDecimal(85528).multiply(new BigDecimal(18))
                    .divide(new BigDecimal(100), 2);
            final BigDecimal secondThreshold = income.subtract(new BigDecimal(85528))
                    .multiply(new BigDecimal(32)).divide(new BigDecimal(100), 2);

            return firstThreshold.add(secondThreshold);
        }
    }
}
