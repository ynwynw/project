package com.pt.reactor.container;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

/**
 * @author nate-pt
 * @date 2022/7/15 10:57
 * @Since 1.8
 * @Description
 */
public class Utils {

    public static RedissonClient getClient(){
        Config config = new Config();
        config.setCodec(new JsonJacksonCodec());
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://127.0.0.1:6379");
        return Redisson.create(config);
    }
}
