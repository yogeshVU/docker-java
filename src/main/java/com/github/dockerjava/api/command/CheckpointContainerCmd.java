package com.github.dockerjava.api.command;

import com.github.dockerjava.api.NotFoundException;

public interface CheckpointContainerCmd extends SyncDockerCmd<Void> {

    public String getContainerId();

    public CheckpointContainerCmd withContainerId(String containerId);

    public CheckpointContainerCmd withImagesDirectory(String imageDir);

    public CheckpointContainerCmd withWorkDirectory(String workDir);

    public CheckpointContainerCmd withLeaveRunning(boolean leaveRunning);

    public CheckpointContainerCmd withTcpEstablished(boolean allowTcp);

    public CheckpointContainerCmd withExternalUnixConnections(boolean allowExtUnix);

    public CheckpointContainerCmd withFileLocks(boolean allowShell);

    /**
     * @throws NotFoundException
     *             No such container
     */
    @Override
    public Void exec() throws NotFoundException;

    public static interface Exec extends DockerCmdSyncExec<CheckpointContainerCmd, Void> {
    }

}