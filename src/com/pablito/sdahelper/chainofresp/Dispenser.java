package com.pablito.sdahelper.chainofresp;

import java.util.List;

public abstract class Dispenser {
    private Dispenser next;

    public Dispenser(final Dispenser next) {
        this.next = next;
    }

    public abstract List<Bill> withdraw(final int amount);

    public Dispenser getNext() {
        return next;
    }
}
