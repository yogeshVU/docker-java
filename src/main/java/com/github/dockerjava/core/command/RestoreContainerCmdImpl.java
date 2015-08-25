package com.github.dockerjava.core.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dockerjava.api.NotFoundException;
import com.github.dockerjava.api.command.RestoreContainerCmd;
import com.github.dockerjava.api.model.CriuOptions;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Inspect the details of a container.
 */
public class RestoreContainerCmdImpl extends AbstrDockerCmd<RestoreContainerCmd, Void> implements
        RestoreContainerCmd {

    private String containerId;

    @JsonProperty("CriuOpts")
    private CriuOptions criuOptions = new CriuOptions();

    @JsonProperty("Force")
    private boolean force = false;

    public RestoreContainerCmdImpl(Exec exec, String containerId) {
        super(exec);
        withContainerId(containerId);
    }

    @Override
    public String getContainerId() {
        return containerId;
    }

    @Override
    public RestoreContainerCmd withContainerId(String containerId) {
        checkNotNull(containerId, "containerId was not specified");
        this.containerId = containerId;
        return this;
    }

    @Override
    public RestoreContainerCmd withCriuOptions(CriuOptions criuOptions) {
        checkNotNull(criuOptions, "Criu Options was not specified");
        this.criuOptions = criuOptions;
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
