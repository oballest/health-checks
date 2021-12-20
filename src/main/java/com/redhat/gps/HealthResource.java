package com.redhat.gps;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/healthChecks")
public class HealthResource {


    @POST
    @Path("/live/{estado}")
    public void changeLiveness(@PathParam("estado") String estado){
        System.setProperty("liveness", estado);
    }

    @POST
    @Path("/ready/{estado}")
    public void changeReadiness(@PathParam("estado") String estado){
        System.setProperty("readiness", estado);
    }
}