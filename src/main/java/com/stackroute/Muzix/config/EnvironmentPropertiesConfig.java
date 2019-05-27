package com.stackroute.Muzix.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringBootConfiguration;
//import sun.tools.java.Environment;
import org.springframework.core.env.Environment;

@SpringBootConfiguration
public class EnvironmentPropertiesConfig implements CommandLineRunner {


    @Autowired
    private Environment env;

    @Override
    public void run(String... args) throws Exception {

      env.getProperty("");

    }
}
