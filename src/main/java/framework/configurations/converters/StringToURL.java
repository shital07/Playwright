package framework.configurations.converters;

import lombok.SneakyThrows;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.net.URL;

public class StringToURL implements Converter<URL> {

    @SneakyThrows
    @Override
    public URL convert(Method method, String s) {
        return new URL(s);
    }
}
