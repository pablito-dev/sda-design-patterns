package com.pablito.sdahelper.chainofresp;

import java.util.ArrayList;
import java.util.List;

public class Dollar20Dispenser extends Dispenser {
    public Dollar20Dispenser(final Dispenser next) {
        super(next);
    }

    @Override
    public List<Bill> withdraw(final int amount) {
        final ArrayList<Bill> bills = new ArrayList<>();
        int remainder = amount;
        if (amount >= 20) {
            final int numberOf20Bills = amount / 20;
            remainder = amount % 20;
            for (int i = 0; i < numberOf20Bills; i++) {
                bills.add(Bill.build20DollarBill());
            }
        }

        if (remainder > 0 && getNext() != null) {
            bills.addAll(getNext().withdraw(remainder));
        }

        return bills;
    }
}
