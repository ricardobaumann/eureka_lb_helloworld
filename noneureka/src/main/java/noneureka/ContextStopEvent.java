package noneureka;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

@Component
public class ContextStopEvent implements ApplicationListener<ContextClosedEvent> {

    private final EurekaClient eurekaClient;

    ContextStopEvent(final EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    public void onApplicationEvent(final ContextClosedEvent contextClosedEvent) {
        try {
            eurekaClient.unregister();
        } catch (final UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
