package com.pablito.sdahelper.chainofresp;

import java.util.ArrayList;
import java.util.List;

public class Dollar50Dispenser extends Dispenser {
    public Dollar50Dispenser(final Dispenser next) {
        super(next);
    }

    @Override
    public List<Bill> withdraw(final int amount) {
        final ArrayList<Bill> bills = new ArrayList<>();
        int remainder = amount;
        if (amount >= 50) {
            final int numberOf20Bills = amount / 50;
            remainder = amount % 50;
            for (int i = 0; i < numberOf20Bills; i++) {
                bills.add(Bill.build50DollarBill());
            }
        }

        if (remainder > 0 && getNext() != null) {
            bills.addAll(getNext().withdraw(remainder));
        }

        return bills;
    }
}
