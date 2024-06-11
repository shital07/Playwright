package framework.configurations;

import framework.configurations.converters.StringToURL;
import org.aeonbits.owner.Config;

import java.net.URL;


@Config.Sources("file:/Users/megatron/Desktop/workspace_shital/Playwright_Java/src/main/resources/config.properties")
public interface IFrameworkConfig extends Config {


    //@ConverterClass(StringToURL.class)
    String url();
}
