package com.pablito.sdahelper.chainofresp;

import java.util.ArrayList;
import java.util.List;

public class Dollar1Dispenser extends Dispenser {
    public Dollar1Dispenser(final Dispenser next) {
        super(next);
    }

    @Override
    public List<Bill> withdraw(final int amount) {
        final ArrayList<Bill> bills = new ArrayList<>();
        if (amount >= 1) {
            for (int i = 0; i < amount; i++) {
                bills.add(Bill.build1DollarBill());
            }
        }

        return bills;
    }
}
