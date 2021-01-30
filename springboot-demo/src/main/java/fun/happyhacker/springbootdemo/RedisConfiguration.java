package fun.happyhacker.springbootdemo;

import fun.happyhacker.redis.RedisPlanetConfigurationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;

import java.util.*;

@Configuration
@EnableConfigurationProperties({
        RedisPlanetConfigurationProperties.class
})
@ConditionalOnProperty(prefix = "spring.redisplanet", name = "enabled", havingValue = "true", matchIfMissing = true)
@AutoConfigureBefore({RedisAutoConfiguration.class})
@RequiredArgsConstructor
@Log4j2
public class RedisConfiguration implements EnvironmentAware {
    private final RedisPlanetConfigurationProperties nodes;
    private final Map<String, RedisProperties> redisPropertiesMap = new LinkedHashMap<>();

    @Override
    public void setEnvironment(Environment environment) {
        String prefix = "spring.redisplanet.";
        for (String each : getRedisNodes(environment, prefix)) {
            log.info("each {}", each);
            redisPropertiesMap.put(each, getRedisNode(environment, prefix, each));
        }
    }

    private RedisProperties getRedisNode(final Environment environment, final String prefix, final String nodeName) {
        return PropertyUtil.handle(environment, prefix + nodeName.trim(), RedisProperties.class);
    }

    private List<String> getRedisNodes(final Environment environment, final String prefix) {
        StandardEnvironment standardEnv = (StandardEnvironment) environment;
        standardEnv.setIgnoreUnresolvableNestedPlaceholders(true);

        log.info("properties {} {}", prefix, standardEnv.getProperty(prefix + "nodes"));
        String inlineNodes = standardEnv.getProperty(prefix + "nodes");
        if (null == inlineNodes) {
            return Collections.emptyList();
        }

        String[] segments = inlineNodes.split(",");
        List<String> result = new ArrayList<>();
        for (String segment : segments) {
            result.add(segment.trim());
        }

        return result;
    }
}
