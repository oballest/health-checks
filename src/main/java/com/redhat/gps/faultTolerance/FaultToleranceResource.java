package com.redhat.gps.faultTolerance;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

@Path("/faultTolerance")
public class FaultToleranceResource {

    @GET
    @Path("/retry")
    @Produces(MediaType.TEXT_PLAIN)
    public String metodoReintento(){

        if("down".equals(System.getProperty("retry", "up"))){
            throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
        }
        return "Reintento";
    }

    @POST
    @Path("/retry/{estado}")
    public void changeReintento(@PathParam("estado") String estado){
        System.setProperty("retry", estado);
    }

    @GET
    @Path("/circuit")
    @Produces(MediaType.TEXT_PLAIN)
    public String metodoCircuitBreaker(){

        if("down".equals(System.getProperty("fuse", "up"))){
            throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
        }
        return "CircuitBreaker";
    }

    @POST
    @Path("/circuit/{estado}")
    public void changeCircuitBreaker(@PathParam("estado") String estado){
        System.setProperty("fuse", estado);
    }

    @GET
    @Path("/timeOut")
    @Produces(MediaType.TEXT_PLAIN)
    public String metodoTimeOut(){

        if("down".equals(System.getProperty("timeOut", "up"))){
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "TimeOut";
    }

    @POST
    @Path("/timeOut/{estado}")
    public void changeTimeOut(@PathParam("estado") String estado){
        System.setProperty("timeOut", estado);
    }
    
}
