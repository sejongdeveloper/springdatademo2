package me.whiteship.springdatademo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class Springdatademo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springdatademo2Application.class, args);
    }

}
