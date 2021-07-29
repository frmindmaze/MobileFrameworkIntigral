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

    public void initializeAppiumParams(){
        AppiumParams params = new AppiumParams();
        params.setPlatformName(System.getProperty("platformName", "Android"));
        params.setUDID(System.getProperty("udid", "900f8d42"));
        params.setDeviceName(System.getProperty("deviceName", "Xioami"));

        switch(params.getPlatformName()){
            case "Android":
                params.setSystemPort(System.getProperty("systemPort", "10000"));
                params.setChromePort(System.getProperty("chromeDriverPort", "11000"));
                break;
            case "iOS":
                break;
            default:
                throw new IllegalStateException("Invalid Platform Name!");
        }
    }
}
