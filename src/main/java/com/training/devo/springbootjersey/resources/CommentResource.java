package com.training.devo.springbootjersey.resources;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by DK05478 on 7/13/2017.
 */

@Component
@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class CommentResource {

    @GET
    public String test(){
        return "new spring sub resource";
    }

}
