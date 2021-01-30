package fun.happyhacker.redis;

import fun.happyhacker.springbootdemo.PropertyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.core.env.Environment;

@RequiredArgsConstructor
public class RedisPlanetUtil {
    public static RedisPlanet getRedisPlanet(final Environment environment, final String prefix, final String nodeName) {
        return new RedisPlanet(nodeName.trim(), PropertyUtil.handle(environment, prefix + nodeName.trim(), RedisProperties.class));
    }
}
