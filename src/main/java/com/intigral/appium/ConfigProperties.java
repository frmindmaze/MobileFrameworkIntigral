package com.intigral.appium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    //*** Class to read the config file***//


    private static Properties prop = new Properties();
    AppiumDriverUtil logger = new AppiumDriverUtil();

    public Properties getProp() throws IOException {
        InputStream is = null;
        String propsFileName = "config.properties";

        if(prop.isEmpty()){
            try{
                logger.log().info("loading config properties");
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                prop.load(is);
            } catch (IOException e) {
                e.printStackTrace();
                logger.log().fatal("Failed to load config properties." + e.toString());
                throw e;
            } finally {
                if(is != null){
                    is.close();
                }
            }
        }
        return prop;
    }
}
