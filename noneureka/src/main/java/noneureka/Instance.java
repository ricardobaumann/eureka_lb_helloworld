package noneureka;

class Instance {
    private final String hostName;
    private final String app;
    private final String ipAddr;
    private final String status;
    private final int port;
    private final int securePort;
    private final String homePageUrl;
    private final String statusPageUrl;
    private final String vipAddress;
    private final String secureVipAddress;
    private final String healthCheckUrl;

    public Instance(final String hostName,
                    final String app,
                    final String ipAddr,
                    final String status,
                    final int port,
                    final int securePort,
                    final String homePageUrl,
                    final String statusPageUrl,
                    final String healthCheckUrl,
                    final String vipAddress,
                    final String secureVipAddress) {
        this.hostName = hostName;
        this.app = app;
        this.ipAddr = ipAddr;
        this.status = status;
        this.port = port;
        this.securePort = securePort;
        this.homePageUrl = homePageUrl;
        this.statusPageUrl = statusPageUrl;
        this.vipAddress = vipAddress;
        this.secureVipAddress = secureVipAddress;
        this.healthCheckUrl = healthCheckUrl;
    }

    public String getHostName() {
        return hostName;
    }

    public String getApp() {
        return app;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public String getStatus() {
        return status;
    }

    public int getPort() {
        return port;
    }

    public int getSecurePort() {
        return securePort;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public String getStatusPageUrl() {
        return statusPageUrl;
    }

    public String getVipAddress() {
        return vipAddress;
    }

    public String getSecureVipAddress() {
        return secureVipAddress;
    }

    public String getHealthCheckUrl() {
        return healthCheckUrl;
    }
}
