package com.github.dockerjava.api.command;

import com.github.dockerjava.api.NotFoundException;
import com.github.dockerjava.api.model.CriuOptions;

public interface RestoreContainerCmd extends SyncDockerCmd<Void> {

    public String getContainerId();

    public RestoreContainerCmd withContainerId(String containerId);

	public RestoreContainerCmd withCriuOptions(CriuOptions criuOptions);

    /**
     * @throws NotFoundException
     *             No such container
     */
    @Override
    public Void exec() throws NotFoundException;

    public static interface Exec extends DockerCmdSyncExec<RestoreContainerCmd, Void> {
    }

}