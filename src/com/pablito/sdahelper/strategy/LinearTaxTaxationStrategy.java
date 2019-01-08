package com.pablito.sdahelper.strategy;

import java.math.BigDecimal;

public class LinearTaxTaxationStrategy implements TaxationStrategy {
    @Override
    public BigDecimal calculateTax(final BigDecimal income) {
        return income.multiply(new BigDecimal(19)).divide(new BigDecimal(100), 2);
    }
}
