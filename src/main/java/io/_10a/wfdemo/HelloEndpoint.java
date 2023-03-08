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

@Path("/hello")
public class HelloEndpoint {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Inject ConfigBean configBean;

    @Inject
    GreetingController greetingController;


    @GET
    @Path("/say")
    public String sayHello() {
        logger.info("Ktoś się dobija !!");
        return configBean.getHello();
    }

    @GET
    @Path("/greetings/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Greeting> getGreetings() {
        List<Greeting> allGreetings = greetingController.getAllGreetings();
        allGreetings.forEach(g -> g.setLang(g.getLang().toUpperCase()));
        allGreetings.forEach(g -> greetingController.saveGreeting(g));
        return allGreetings;
    }

}
