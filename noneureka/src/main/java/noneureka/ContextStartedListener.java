package noneureka;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

@Component
public class ContextStartedListener implements ApplicationListener<ContextStartedEvent> {

    private final EurekaClient eurekaClient;

    ContextStartedListener(final EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    public void onApplicationEvent(final ContextStartedEvent contextStartedEvent) {
        try {
            eurekaClient.register();
        } catch (final UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
