package fun.happyhacker.redis;

import fun.happyhacker.springbootdemo.Redis6379MasterProperties;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Autowired
    private Redis6379MasterProperties redis6379MasterProperties;

    @Bean(name = "redis6379master")
    public RedisTemplate<String, Object> redis6379master() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redis6379MasterProperties.getHost(), redis6379MasterProperties.getPort());
        GenericObjectPoolConfig<?> genericObjectPoolConfig = new GenericObjectPoolConfig<>();
        LettuceClientConfiguration lettuceClientConfiguration = LettucePoolingClientConfiguration.builder()
                .poolConfig(genericObjectPoolConfig)
                .build();
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration, lettuceClientConfiguration);
        connectionFactory.afterPropertiesSet();

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

}

