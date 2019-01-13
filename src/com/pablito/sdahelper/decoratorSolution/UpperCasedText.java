package com.pablito.sdahelper.decoratorSolution;

import java.io.FileNotFoundException;

public class UpperCasedText implements Text {
    private final Text origin;

    public UpperCasedText(final Text origin) {
        this.origin = origin;
    }

    @Override
    public String read() throws FileNotFoundException {
        return origin.read().toUpperCase();
    }
}
