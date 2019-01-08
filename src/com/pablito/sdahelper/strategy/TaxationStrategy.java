package com.pablito.sdahelper.strategy;

import java.math.BigDecimal;

public interface TaxationStrategy {
    BigDecimal calculateTax(final BigDecimal income);
}
