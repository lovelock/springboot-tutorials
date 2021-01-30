package fun.happyhacker.springbootdemo.redis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisTest {

//    @Autowired
//    @Qualifier("jedisTemplate")
//    private RedisTemplate<String, Serializable> jedisTemplate;

//    @Autowired
//    @Qualifier("lettuceTemplate")
//    private RedisTemplate<String, Serializable> lettuceTemplate;

    @Test
    void testSingleJedis() {
//        jedisTemplate.opsForValue().set("foo", "bar");
//        String value = (String) jedisTemplate.opsForValue().get("foo");
//        assertEquals("bar", value);
    }

//    @Test
//    void testSingleLettuce() {
//        lettuceTemplate.opsForValue().set("foo", "bar");
//        String value = (String) lettuceTemplate.opsForValue().get("foo");
//        assertEquals("bar", value);
//    }
}
