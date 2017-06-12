package messagelogger;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ComponentScan(basePackages = "messagelogger")
public @interface EnableEndpointLogging {
}