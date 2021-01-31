package fun.happyhacker.springbootdemo;

import fun.happyhacker.redis.RedisPlanetUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.*;

@Configuration
@ConditionalOnProperty(prefix = "spring.redisplanet", name = "enabled", havingValue = "true", matchIfMissing = true)
@AutoConfigureBefore({RedisAutoConfiguration.class})
@RequiredArgsConstructor
@Log4j2
public class RedisConfiguration implements EnvironmentAware , BeanDefinitionRegistryPostProcessor {
    private final Map<String, RedisProperties> redisPropertiesMap = new LinkedHashMap<>();

    @Override
    public void setEnvironment(Environment environment) {
        String prefix = "spring.redisplanet.";
        for (String each : getRedisNodes(environment, prefix)) {
            log.info("each {}", each);
            RedisProperties props = getRedisNode(environment, prefix, each);
            log.info("redis properties {} {}:{}", each, props.getHost(), props.getPort());
            redisPropertiesMap.put(each, props);
        }
    }

    private RedisTemplate<String, Object> createTemplate(String name) {
        RedisProperties props = redisPropertiesMap.get(name);
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(props.getHost());
        redisStandaloneConfiguration.setPort(props.getPort());
        redisStandaloneConfiguration.setDatabase(props.getDatabase());
        if (props.getUsername() != null) {
            redisStandaloneConfiguration.setUsername(props.getUsername());
        }
        if (props.getPassword() != null) {
            redisStandaloneConfiguration.setPassword(props.getPassword());
        }
        GenericObjectPoolConfig<?> poolConfig = new GenericObjectPoolConfig<>();
        poolConfig.setMaxIdle(props.getJedis().getPool().getMaxIdle());
        poolConfig.setMaxTotal(props.getJedis().getPool().getMaxIdle());
        poolConfig.setMinIdle(props.getJedis().getPool().getMinIdle());
        poolConfig.setMaxWaitMillis(props.getJedis().getPool().getMaxWait().toMillis());
        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().usePooling()
                .poolConfig(poolConfig)
                .build();
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    private RedisProperties getRedisNode(final Environment environment, final String prefix, final String nodeName) {
        return RedisPlanetUtil.getRedisPlanet(environment, prefix, nodeName).getProperties();
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

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        for (String name : redisPropertiesMap.keySet()) {
            registry.registerBeanDefinition(name + "RedisTemplate", BeanDefinitionBuilder.genericBeanDefinition(RedisTemplate.class, () -> createTemplate(name)).getBeanDefinition());
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
