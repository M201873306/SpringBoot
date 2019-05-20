package com.hust.springbootsso;

import com.hust.springbootsso.entity.TbUser;
import com.hust.springbootsso.tool.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSsoApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void contextLoads() {
        stringRedisTemplate.opsForValue().set("REDIS_SESSION_KEY", JsonUtils.objectToJson(new TbUser()));
    }

}
