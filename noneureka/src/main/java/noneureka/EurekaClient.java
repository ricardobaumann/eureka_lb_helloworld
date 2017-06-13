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

    public void register() throws UnknownHostException {
        final String hostname = InetAddress.getLocalHost().getHostName();
        final String ipAddress = InetAddress.getLocalHost().getHostAddress();
        final String baseUrl = String.format("http://%s:%d/", hostname, serverPort);
        final Instance instance = new Instance(hostname,
                appName,
                ipAddress, "UP",
                9123, 9123, baseUrl,
                String.format("%s/info", baseUrl),
                String.format("%s/health", baseUrl), appName,
                appName);

        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
        headers.setContentType(MediaType.APPLICATION_XML);
        final String body = String.format("<instance>\n" +
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
                        "</instance>", instance.getHostName(), instance.getApp(), instance.getIpAddr(), instance.getVipAddress(),
                instance.getStatus(), instance.getPort(), instance.getSecurePort(), instance.getHomePageUrl(), instance.getStatusPageUrl(),
                instance.getHealthCheckUrl());
        final HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        restTemplate.exchange(eurekaBaseUrl + instance.getApp(), HttpMethod.POST, requestEntity, Void.class);
    }

    public void unregister() throws UnknownHostException {
        final String hostname = InetAddress.getLocalHost().getHostName();
        restTemplate.delete(eurekaBaseUrl + "/{name}/{id}", appName, hostname);
    }
}

/*
<instance>
  <hostName>ricardos-mbp.asv.local</hostName>
  <app>tester</app>
  <ipAddr>10.10.75.13</ipAddr>
  <vipAddress>tester</vipAddress>
  <secureVipAddress>tester</secureVipAddress>
  <status>UP</status>
  <port enavbled="true">1234</port>
  <securePort enabled="false">443</securePort>
  <homePageUrl>http://ricardos-mbp.asv.local:1234</homePageUrl>
  <statusPageUrl>http://ricardos-mbp.asv.local:4444/info</statusPageUrl>
  <healthCheckUrl>http://ricardos-mbp.asv.local:4444/health</healthCheckUrl>
  <dataCenterInfo class="com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo">
	<name>MyOwn</name>
	</dataCenterInfo>
  <leaseInfo>
    <evictionDurationInSecs>745</evictionDurationInSecs>
  </leaseInfo>
  <metadata />
</instance>
 */
