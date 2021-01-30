package fun.happyhacker.redis;

import com.google.common.collect.Sets;

import java.util.Collection;

public class RedisConfigs {
    private static final String SET_METHOD_PREFIX = "set";

    private static final Collection<Class<?>> GENERAL_CLASS_TYPE;

    static {
        GENERAL_CLASS_TYPE = Sets.newHashSet(boolean.class, Boolean.class, int.class, Integer.class, long.class, Long.class, String.class, Collection.class);
    }

//    public static RedisProperties getRedisConfigs() {
//
//    }
}
