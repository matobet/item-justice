package com.matobet.itemjustice.config;

import com.matobet.itemjustice.rest.SampleEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.matobet.itemjustice.rest");
    }
}
