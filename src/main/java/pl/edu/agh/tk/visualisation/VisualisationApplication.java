package pl.edu.agh.tk.visualisation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VisualisationApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisualisationApplication.class, args);
    }

}
