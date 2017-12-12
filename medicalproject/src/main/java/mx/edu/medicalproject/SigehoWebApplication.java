package mx.edu.medicalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class SigehoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SigehoWebApplication.class, args);

    }
}
