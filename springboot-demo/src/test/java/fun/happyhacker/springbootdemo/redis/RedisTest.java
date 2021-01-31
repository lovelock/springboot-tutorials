package fun.happyhacker.springbootdemo.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RedisTest {

//    @Autowired
//    @Qualifier("r2RedisTemplate")
//    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ApplicationContext context;

    @Test
    void testSingleJedis() {
        RedisTemplate<String, Object> redisTemplate  = context.getBean("r2RedisTemplate", RedisTemplate.class);
        redisTemplate.opsForValue().set("foo2", "bar");
        String value = (String) redisTemplate.opsForValue().get("foo2");
        assertEquals("bar", value);
    }

//    @Test
//    void testSingleLettuce() {
//        lettuceTemplate.opsForValue().set("foo", "bar");
//        String value = (String) lettuceTemplate.opsForValue().get("foo");
//        assertEquals("bar", value);
//    }
}
