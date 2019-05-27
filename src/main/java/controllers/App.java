package controllers;

import business.pegs.PegsFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import services.CodeMakerService;

import java.io.IOException;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean CodeMakerService codeMakerService() throws IOException {
        return new CodeMakerService();
    }

    @Bean PegsFactory pegsFactory() {
        return new PegsFactory();
    }

}