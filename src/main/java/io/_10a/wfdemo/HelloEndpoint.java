package io._10a.wfdemo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/helo")
public class HelloEnpoint {

    @GET
    @Path("/say")
    public String sayHello() {
        return "Hello!";
    }

}
