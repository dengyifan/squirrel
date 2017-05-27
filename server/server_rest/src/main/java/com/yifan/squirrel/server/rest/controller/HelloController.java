package com.yifan.squirrel.server.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * Created by yifan on 17-5-26.
 */
@Path("hello")
public class HelloController {

    @Context
    private UriInfo context;

    public HelloController(){}

    @GET
    @Produces("text/html")
    public String getHtml(){
        return "<html lang=\"en\"><body><h1>Hello,World2!</h1></body></html>";
    }
}
