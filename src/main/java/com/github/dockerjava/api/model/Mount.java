package com.github.dockerjava.api.model;

public class Mount {
    private final String name;

    private final String source;

    private final String destination;

    private final String driver;

    private final String mode;

    private final boolean rw;

    public Mount(String name, String source, String destination, String driver, String mode, boolean rw) {
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.driver = driver;
        this.mode = mode;
        this.rw = rw;
    }

    public String getSource() {
        return source;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    public String getDriver() {
        return driver;
    }

    public String getMode() {
        return mode;
    }

    public boolean getRW() {
        return rw;
    }

    @Override
    public String toString() {
        return "Mount{" +
                "name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", driver='" + driver + '\'' +
                ", mode='" + mode + '\'' +
                ", rw=" + rw +
                '}';
    }
}
