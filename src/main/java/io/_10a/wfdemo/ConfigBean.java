package io._10a.wfdemo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ConfigBean {

    private final String hello = "Hello!";

    public String getHello() {
        return hello;
    }
}
