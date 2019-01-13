package com.pablito.sdahelper.decoratorSolution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

public class TextInFile implements Text {
    private File file;

    public TextInFile(final File file) {
        this.file = file;
    }

    @Override
    public String read() throws FileNotFoundException {
        final BufferedReader reader = new BufferedReader(new FileReader(file));

        return reader.lines().collect(Collectors.joining("\n"));
    }
}
