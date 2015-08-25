package com.github.dockerjava.jaxrs;

import com.github.dockerjava.api.command.RestoreContainerCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.client.Entity.entity;

public class RestoreContainerCmdExec extends AbstrSyncDockerCmdExec<RestoreContainerCmd, Void>
        implements RestoreContainerCmd.Exec {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestoreContainerCmdExec.class);

    public RestoreContainerCmdExec(WebTarget baseResource) {
        super(baseResource);
    }

    @Override
    protected Void execute(RestoreContainerCmd command) {
        WebTarget webResource = getBaseResource().path("/containers/{id}/restore").resolveTemplate("id",
                command.getContainerId());

        LOGGER.debug("POST: {}", webResource);
        webResource.request().accept(MediaType.APPLICATION_JSON)
                .post(entity(command, MediaType.APPLICATION_JSON));

        return null;
    }

}
