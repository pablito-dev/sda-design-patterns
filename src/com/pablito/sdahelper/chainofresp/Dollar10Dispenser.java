package com.pablito.sdahelper.chainofresp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Dollar10Dispenser extends Dispenser {
    public Dollar10Dispenser(final Dispenser next) {
        super(next);
    }

    @Override
    public List<Bill> withdraw(final int amount) {
        final ArrayList<Bill> bills = new ArrayList<>();
        int remainder = amount;
        if (amount >= 10) {
            final int numberOf10Bills = amount / 10;
            remainder = amount % 10;
            for (int i = 0; i < numberOf10Bills; i++) {
                bills.add(Bill.build10DollarBill());
            }
        }

        if (remainder > 0 && getNext() != null) {
            bills.addAll(getNext().withdraw(remainder));
        }

        return bills;
    }
}
