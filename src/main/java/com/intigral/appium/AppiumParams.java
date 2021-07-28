package com.intigral.appium;

public class AppiumParams {

    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> chromePort = new ThreadLocal<String>();
    private static ThreadLocal<String> LocalPort = new ThreadLocal<String>();
    private static ThreadLocal<String> ProxyPort = new ThreadLocal<String>();


    public void setPlatformName(String setPlatformName) {
        platformName.set(setPlatformName);
    }

    public String getPlatformName() {
        return platformName.get();
    }

    public void setUDID(String setUdid) {
        udid.set(setUdid);
    }

    public String getUDID() {
        return udid.get();
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String setDeviceName) {
        deviceName.set(setDeviceName);
    }

    public String getSystemPort() {
        return systemPort.get();
    }

    public void setSystemPort(String setSystemPort) {
        systemPort.set(setSystemPort);
    }

    public String getChromePort() {
        return chromePort.get();
    }

    public void setChromePort(String setChromePort) {
        chromePort.set(setChromePort);
    }

    public String getLocalPort() {
        return LocalPort.get();
    }

    public void setLocalPort(String setLocalPort) {
        LocalPort.set(setLocalPort);
    }

    public String ProxyPort() {
        return ProxyPort.get();
    }

    public void setProxyPort(String setProxyPort) {
        ProxyPort.set(setProxyPort);
    }
}
