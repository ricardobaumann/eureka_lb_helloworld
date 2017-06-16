package noneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NonEurekaApplication {

    public static void main(final String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(NonEurekaApplication.class, args);
        context.start();
        context.registerShutdownHook();
    }

    @GetMapping
    public Hello hello() {
        return new Hello("hey");
    }

}
