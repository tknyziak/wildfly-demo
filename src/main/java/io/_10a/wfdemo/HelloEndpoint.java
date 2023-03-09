package io._10a.wfdemo;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Path("/hello")
public class HelloEndpoint {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Inject ConfigBean configBean;

    @Inject
    GreetingController greetingController;

    @Inject
    GreetingMapper greetingMapper;

    @GET
    @Path("/say")
    public String sayHello() {
        logger.info("Ktoś się dobija !!");
        return configBean.getHello();
    }

    @GET
    @Path("/greetings/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GreetingDTO> getGreetings() {
        List<Greeting> allGreetings = greetingController.getAllGreetings();
        return allGreetings.stream().map(greetingMapper::fromGreeting).collect(Collectors.toList());
    }

}
