package fun.happyhacker.springbootdemo.redis;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Log4j2
public class RedisTest {

//    @Autowired
//    private ApplicationContext context;
//
//    @Test
//    void testSingleJedis() {
//        RedisTemplate<String, Object> redisTemplate  = context.getBean("r2RedisTemplate", RedisTemplate.class);
//        redisTemplate.opsForValue().set("foo2", "bar");
//        String value = (String) redisTemplate.opsForValue().get("foo2");
//        assertEquals("bar", value);
//    }

    @Autowired
    private RedisTemplate<String, Object> redis6379master;

    @Test
    void initJedis() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("local-docker");
        redisStandaloneConfiguration.setPort(6379);
        redisStandaloneConfiguration.setDatabase(0);

        GenericObjectPoolConfig<?> genericObjectPoolConfig = new GenericObjectPoolConfig<>();
        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder()
                .usePooling()
                .poolConfig(genericObjectPoolConfig)
                .build();

        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
        connectionFactory.afterPropertiesSet();
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.afterPropertiesSet();

        int size = 200;
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                redisTemplate.opsForValue().set("redis", "good ");
                String value = (String) redisTemplate.opsForValue().get("redis");
                log.info("redis value {}", value);
            }).start();
        }
    }

    @Test
    void initLettuce() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("local-docker", 6379);
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

        int size = 200;
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                redisTemplate.opsForValue().set("redis", "good ");
                String value = (String) redisTemplate.opsForValue().get("redis");
                log.info("redis value {}", value);
            }).start();
        }
    }

    @Test
    void testMulti() {

        redis6379master.opsForValue().set("master", "value");

        assertEquals("value", redis6379master.opsForValue().get("master"));
    }

}
