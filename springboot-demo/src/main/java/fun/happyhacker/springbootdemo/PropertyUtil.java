package fun.happyhacker.springbootdemo;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;

public class PropertyUtil {
    public static <T> T handle(final Environment environment, final String prefix, final Class<T> targetClass) {
        String prefixParam = prefix.endsWith(".") ? prefix.substring(0, prefix.length() - 1) : prefix;
        return Binder.get(environment).bind(prefixParam, targetClass).get();
    }
}
