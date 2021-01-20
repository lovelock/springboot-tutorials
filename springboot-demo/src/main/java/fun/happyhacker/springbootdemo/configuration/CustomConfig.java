package fun.happyhacker.springbootdemo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "hello")
@Data
public class CustomConfig {
    private String world;
    private String past;
}
