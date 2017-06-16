package noneureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;

@Component
public class EurekaClient {

    private static final String BODY_TENPLATE = "<instance>\n" +
            "  <hostName>%s</hostName>\n" +
            "  <app>%s</app>\n" +
            "  <ipAddr>%s</ipAddr>\n" +
            "  <vipAddress>%s</vipAddress>\n" +
            "  <secureVipAddress>tester</secureVipAddress>\n" +
            "  <status>%s</status>\n" +
            "  <port enavbled=\"true\">%d</port>\n" +
            "  <securePort enabled=\"false\">%d</securePort>\n" +
            "  <homePageUrl>%s</homePageUrl>\n" +
            "  <statusPageUrl>%s</statusPageUrl>\n" +
            "  <healthCheckUrl>%s</healthCheckUrl>\n" +
            "  <dataCenterInfo class=\"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo\">\n" +
            "\t<name>MyOwn</name>\n" +
            "\t</dataCenterInfo>\n" +
            "  <leaseInfo>\n" +
            "    <evictionDurationInSecs>745</evictionDurationInSecs>\n" +
            "  </leaseInfo>\n" +
            "  <metadata />\n" +
            "</instance>";

    private final RestTemplate restTemplate;
    private final int serverPort;
    private final String appName;
    private final String eurekaBaseUrl;

    EurekaClient(final RestTemplate restTemplate,
                 @Value("${server.port}") final String serverPort,
                 @Value("${spring.application.name}") final String appName,
                 @Value("${eureka.baseUrl}") final String eurekaBaseUrl) {
        this.restTemplate = restTemplate;
        this.serverPort = Integer.parseInt(serverPort);
        this.appName = appName;
        this.eurekaBaseUrl = eurekaBaseUrl;
    }

    void register() throws UnknownHostException {
        final String hostname = InetAddress.getLocalHost().getHostName();
        final String ipAddress = InetAddress.getLocalHost().getHostAddress();
        final String baseUrl = String.format("http://%s:%d/", hostname, serverPort);

        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
        headers.setContentType(MediaType.APPLICATION_XML);
        final String body = String.format(BODY_TENPLATE, hostname,
                appName,
                ipAddress,
                appName,
                "UP",
                serverPort,
                serverPort,
                baseUrl,
                String.format("%s/info", baseUrl),
                String.format("%s/health", baseUrl));
        final HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
        restTemplate.exchange(eurekaBaseUrl + appName, HttpMethod.POST, requestEntity, Void.class);
    }

    public void unregister() throws UnknownHostException {
        final String hostname = InetAddress.getLocalHost().getHostName();
        restTemplate.delete(eurekaBaseUrl + "/{name}/{id}", appName, hostname);
    }
}
