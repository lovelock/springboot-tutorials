package fun.happyhacker.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

@Data
@AllArgsConstructor
public class RedisPlanet {
    private String nodes;
    private RedisProperties properties;
}
