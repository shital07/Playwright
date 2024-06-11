package framework.configurations;

import org.aeonbits.owner.ConfigCache;

public class ConfigFactory {

    private ConfigFactory(){

    }



    public static IFrameworkConfig getConfig(){
       return ConfigCache.getOrCreate(IFrameworkConfig.class);
    }

}
