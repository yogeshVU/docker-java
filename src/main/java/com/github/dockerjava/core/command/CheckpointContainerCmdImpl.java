package com.github.dockerjava.core.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dockerjava.api.NotFoundException;
import com.github.dockerjava.api.command.CheckpointContainerCmd;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Inspect the details of a container.
 */
public class CheckpointContainerCmdImpl extends AbstrDockerCmd<CheckpointContainerCmd, Void> implements
        CheckpointContainerCmd {

    private String containerId;

    @JsonProperty("ImagesDirectory")
    private String imagesDirectory = "";

    @JsonProperty("WorkDirectory")
    private String workDirectory = "";

    @JsonProperty("LeaveRunning")
    private boolean leaveRunning = false;

    @JsonProperty("TcpEstablished")
    private boolean tcpEstablished = false;

    @JsonProperty("ExternalUnixConnections")
    private boolean externalUnixConnections = false;

    @JsonProperty("ShellJob")
    private boolean shellJob = false;

    public CheckpointContainerCmdImpl(Exec exec, String containerId) {
        super(exec);
        withContainerId(containerId);
    }

    @Override
    public String getContainerId() {
        return containerId;
    }

    @Override
    public CheckpointContainerCmd withContainerId(String containerId) {
        checkNotNull(containerId, "containerId was not specified");
        this.containerId = containerId;
        return this;
    }

    @Override
    public CheckpointContainerCmd withImagesDirectory(String imagesDirectory) {
        checkNotNull(imagesDirectory, "imagesDirectory was not specified");
        this.imagesDirectory = imagesDirectory;
        return this;
    }

    @Override
    public CheckpointContainerCmd withWorkDirectory(String workDirectory) {
        checkNotNull(workDirectory, "workDirectory was not specified");
        this.workDirectory = workDirectory;
        return this;
    }

    @Override
    public CheckpointContainerCmd withLeaveRunning(boolean leaveRunning) {
        this.leaveRunning = leaveRunning;
        return this;
    }

    @Override
    public CheckpointContainerCmd withTcpEstablished(boolean tcpEstablished) {
        this.tcpEstablished = tcpEstablished;
        return this;
    }

    @Override
    public CheckpointContainerCmd withExternalUnixConnections(boolean externalUnixConnections) {
        this.externalUnixConnections = externalUnixConnections;
        return this;
    }

    @Override
    public CheckpointContainerCmd withShellJob(boolean shellJob) {
        this.shellJob = shellJob;
        return this;
    }

    @Override
    public String toString() {
        return "checkpoint " + containerId;
    }

    /**
     * @throws NotFoundException
     *             No such container
     */
    @Override
    public Void exec() throws NotFoundException {
        return super.exec();
    }
}
