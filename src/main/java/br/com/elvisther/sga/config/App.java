package br.com.elvisther.sga.config;

import java.util.TimeZone;

import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class App
{
    @PostConstruct
    public void init()
    {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Cuiaba"));
    }
}
