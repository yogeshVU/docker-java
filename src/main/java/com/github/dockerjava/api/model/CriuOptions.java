package com.github.dockerjava.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.ToStringBuilder;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Inspect the details of a container.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CriuOptions {

    @JsonProperty("ImagesDirectory")
    private String imagesDirectory = "";

    @JsonProperty("WorkDirectory")
    private String workDirectory = "";

    @JsonProperty("TcpEstablished")
    private boolean tcpEstablished = true;

    @JsonProperty("ExternalUnixConnections")
    private boolean externalUnixConnections = true;

    @JsonProperty("FileLocks")
    private boolean fileLocks = true;

    public CriuOptions() {
        this("");
    }

    public CriuOptions(String imagesDirectory) {
        this(imagesDirectory, "");
    }

    public CriuOptions(String imagesDirectory, String workDirectory) {
        this(imagesDirectory, workDirectory, true);
    }

    public CriuOptions(String imagesDirectory, String workDirectory, boolean tcpEstablished) {
        this(imagesDirectory, workDirectory, tcpEstablished, true);
    }

    public CriuOptions(String imagesDirectory, String workDirectory, boolean tcpEstablished, boolean externalUnixConnections) {
        this(imagesDirectory, workDirectory, tcpEstablished, externalUnixConnections, true);
    }

    public CriuOptions(String imagesDirectory, String workDirectory, boolean tcpEstablished, boolean externalUnixConnections, boolean fileLocks) {
        this.imagesDirectory = imagesDirectory;
        this.workDirectory = workDirectory;
        this.tcpEstablished = tcpEstablished;
        this.externalUnixConnections = externalUnixConnections;
        this.fileLocks = fileLocks;
    }

    public String getImagesDirectory() {
        return imagesDirectory;
    }

    public String getWorkDirectory() {
        return workDirectory;
    }

    public boolean isTcpEstablished() {
        return tcpEstablished;
    }

    public boolean isExternalUnixConnections() {
        return externalUnixConnections;
    }

    public boolean isFileLocks() {
        return fileLocks;
    }

    public void setImagesDirectory(String imagesDirectory) {
        this.imagesDirectory = imagesDirectory;
    }

    public void setWorkDirectory(String workDirectory) {
        this.workDirectory = workDirectory;
    }

    public void setTcpEstablished(boolean tcpEstablished) {
        this.tcpEstablished = tcpEstablished;
    }

    public void setExternalUnixConnections(boolean externalUnixConnections) {
        this.externalUnixConnections = externalUnixConnections;
    }

    public void setFileLocks(boolean fileLocks) {
        this.fileLocks = fileLocks;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
