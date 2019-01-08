package com.pablito.sdahelper.singelton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private static final String FILE_NAME = "log.txt";

    private Logger() {
    }

    public static Logger get() {
        synchronized (Logger.class) {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }
    }

    public void log(final String message) throws IOException {
        final BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
        writer.append(message).append("\n");

        writer.close();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }
}
