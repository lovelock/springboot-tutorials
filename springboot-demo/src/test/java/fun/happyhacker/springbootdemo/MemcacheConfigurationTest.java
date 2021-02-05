package fun.happyhacker.springbootdemo;

import com.weibo.admin.starter.data.memcache.MemcachedPool;
import lombok.extern.slf4j.Slf4j;
import net.spy.memcached.MemcachedClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class MemcacheConfigurationTest {

    @Autowired
    private MemcachedPool memcachedPool;

    @Autowired
    @Qualifier("mc11211MCClient")
    private MemcachedClient memcachedClient;

    @Test
    void testClientSetGet() {
//        log.info("memcache pool map {}", memcachedPool.getMap());
        memcachedClient.set("key", 20000, "fine");
        String value = (String)memcachedClient.get("key");
        assertEquals( "fine", value);
    }

}