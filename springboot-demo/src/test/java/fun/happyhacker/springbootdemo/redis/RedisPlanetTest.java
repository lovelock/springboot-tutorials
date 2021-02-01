package fun.happyhacker.springbootdemo.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RedisPlanetTest {
    @Autowired
    private ApplicationContext context;

    @Autowired
    @Qualifier("r1RedisTemplate")
    private RedisTemplate<String, Object> r1RedisTemplate;

    @Test
    void test() {
        r1RedisTemplate.opsForValue().set("r1test", "r1testvalue");
        assertEquals("r1testvalue", r1RedisTemplate.opsForValue().get("r1test"));

        RedisTemplate<String, Object> r2RedisTemplate = context.getBean("r2RedisTemplate", RedisTemplate.class);
        r2RedisTemplate.opsForValue().set("r2test", "r2testvalue");
        assertEquals("r2testvalue", r2RedisTemplate.opsForValue().get("r2test"));
    }
}
