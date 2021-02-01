package fun.happyhacker.springbootdemo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@ConfigurationProperties(prefix = "redis-cluster.redis6379master")
@Configuration
@Data
public class Redis6379MasterProperties {
    private String host;
    private int port;
    private int database;
    private String password;
    private Duration connectTimeout;
}
