package com.github.dockerjava.jaxrs;

import com.github.dockerjava.api.command.CheckpointContainerCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.client.Entity.entity;

public class CheckpointContainerCmdExec extends AbstrSyncDockerCmdExec<CheckpointContainerCmd, Void>
        implements CheckpointContainerCmd.Exec {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckpointContainerCmdExec.class);

    public CheckpointContainerCmdExec(WebTarget baseResource) {
        super(baseResource);
    }

    @Override
    protected Void execute(CheckpointContainerCmd command) {
        WebTarget webResource = getBaseResource().path("/containers/{id}/checkpoint").resolveTemplate("id",
                command.getContainerId());

        LOGGER.debug("POST: {}", webResource);
        webResource.request().accept(MediaType.APPLICATION_JSON)
                .post(entity(command, MediaType.APPLICATION_JSON));

        return null;
    }

}
