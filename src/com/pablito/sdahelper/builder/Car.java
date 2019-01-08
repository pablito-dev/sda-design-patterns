package com.pablito.sdahelper.builder;

import com.pablito.sdahelper.singelton.Logger;

import java.io.IOException;

public class Car {
    private double engine;
    private String undercarriage;
    private String body;
    private String inside;

    private Car(final Builder builder) {
        this.engine = builder.engine;
        this.undercarriage = builder.undercarriage;
        this.body = builder.body;
        this.inside = builder.inside;
    }

    public double getEngine() {
        return engine;
    }

    public String getUndercarriage() {
        return undercarriage;
    }

    public String getBody() {
        return body;
    }

    public String getInside() {
        return inside;
    }

    public static class Builder {
        private double engine;
        private String undercarriage;
        private String body;
        private String inside;

        public Builder engine(final double engine) throws IOException {
            this.engine = engine;
            Logger.get().log(String.format("engine built with %s", engine));
            return this;
        }

        public Builder undercarriage(final String undercarriage) throws IOException {
            this.undercarriage = undercarriage;
            Logger.get().log(String.format("undercarriage built with %s", undercarriage));
            return this;
        }

        public Builder body(final String body) throws IOException {
            this.body = body;
            Logger.get().log(String.format("body built with: %s", body));
            return this;
        }

        public Builder inside(final String inside) throws IOException {
            this.inside = inside;
            Logger.get().log(String.format("inside built with: %s", inside));
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
