package fun.happyhacker.springbootdemo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "database.ab.master")
@Data
public class DbConfig {
    private String host;
}
