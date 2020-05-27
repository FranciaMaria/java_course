package com.qualityhouse.springdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CommandLineStartupRunner implements CommandLineRunner {

    private String[] planetNames;

    @Override
    public void run(String... args) throws Exception {
        this.planetNames = args;
    }

    public String[] getPlanetNames() {
        return planetNames;
    }

}
