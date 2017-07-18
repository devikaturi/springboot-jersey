package com.training.devo.springbootjersey;

import com.training.devo.springbootjersey.resources.MessageController;
import com.training.devo.springbootjersey.resources.ProfileController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Created by DK05478 on 7/13/2017.
 * Register all the end point classed  ( all the resources)
 * test the
 */
@Component
public class CustomJerseyConfig extends ResourceConfig {
    public CustomJerseyConfig(){

        packages("com.training.devo.springbootjersey.resources");
        //
        register(MessageController.class);
        register(ProfileController.class);
    }
}
