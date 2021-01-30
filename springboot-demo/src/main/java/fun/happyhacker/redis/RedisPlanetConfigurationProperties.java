package fun.happyhacker.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

@ConfigurationProperties(prefix = "spring.redisplanet")
@Getter
@Setter
public class RedisPlanetConfigurationProperties {
    private Properties props = new Properties();
}
