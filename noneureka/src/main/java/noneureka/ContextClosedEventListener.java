package noneureka;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

@Component
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    private final EurekaClient eurekaClient;

    ContextClosedEventListener(final EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @Override
    public void onApplicationEvent(final ContextClosedEvent contextClosedEvent) {
        try {
            eurekaClient.unregister();
        } catch (final UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
