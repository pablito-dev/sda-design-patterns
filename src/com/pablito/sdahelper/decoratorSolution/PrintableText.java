package com.pablito.sdahelper.decoratorSolution;

import java.io.FileNotFoundException;

public class PrintableText implements Text {
    private final Text origin;

    public PrintableText(final Text origin) {
        this.origin = origin;
    }

    @Override
    public String read() throws FileNotFoundException {
        return this.origin.read()
                .replaceAll("[^\\p{Print}]", "");
    }
}
