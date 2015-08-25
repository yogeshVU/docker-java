package com.github.dockerjava.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.dockerjava.api.NotFoundException;
import com.github.dockerjava.api.command.RestoreContainerCmd;
import com.github.dockerjava.core.command.AbstrDockerCmd;
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
    private boolean tcpEstablished = false;

    @JsonProperty("ExternalUnixConnections")
    private boolean externalUnixConnections = false;

    @JsonProperty("ShellJob")
    private boolean shellJob = false;

    public CriuOptions() {
        this("");
    }

    public CriuOptions(String imagesDirectory) {
        this(imagesDirectory, "");
    }

    public CriuOptions(String imagesDirectory, String workDirectory) {
        this(imagesDirectory, workDirectory, false);
    }

    public CriuOptions(String imagesDirectory, String workDirectory, boolean tcpEstablished) {
        this(imagesDirectory, workDirectory, tcpEstablished, false);
    }

    public CriuOptions(String imagesDirectory, String workDirectory, boolean tcpEstablished, boolean externalUnixConnections) {
        this(imagesDirectory, workDirectory, tcpEstablished, externalUnixConnections, false);
    }

    public CriuOptions(String imagesDirectory, String workDirectory, boolean tcpEstablished, boolean externalUnixConnections, boolean shellJob) {
        this.imagesDirectory = imagesDirectory;
        this.workDirectory = workDirectory;
        this.tcpEstablished = tcpEstablished;
        this.externalUnixConnections = externalUnixConnections;
        this.shellJob = shellJob;
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

    public boolean isShellJob() {
        return shellJob;
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

    public void setShellJob(boolean shellJob) {
        this.shellJob = shellJob;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
