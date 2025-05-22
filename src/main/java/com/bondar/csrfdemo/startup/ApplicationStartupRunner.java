package com.bondar.csrfdemo.startup;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URI;

@Component
public class ApplicationStartupRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String url = "http://localhost:8081/login";
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI(url));
        } else {
            System.out.println("Please open manually: " + url);
        }
    }
}
