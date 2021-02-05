package fun.happyhacker.springbootdemo;

import com.weibo.admin.starter.data.memcache.MemcachedPool;
import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class MemcacheConfiguration {

    @Autowired
    private MemcachedPool memcachedPool;

    @Bean(name = "mc11211MCClient")
    public MemcachedClient getMC112111() throws IOException {
        return memcachedPool.getMemcachedClient("mc11211");
    }
}
