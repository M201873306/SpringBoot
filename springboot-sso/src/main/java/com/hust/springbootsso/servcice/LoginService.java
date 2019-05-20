package com.hust.springbootsso.servcice;

import com.hust.springbootsso.entity.ResultObject;
import com.hust.springbootsso.mapper.TbUserMapper;
import com.hust.springbootsso.entity.TbUser;
import com.hust.springbootsso.model.TbUserExample;

import com.hust.springbootsso.tool.CookieUtils;
import com.hust.springbootsso.tool.JsonUtils;
import net.minidev.json.JSONUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import com.hust.springbootsso.model.TbUserExample;
@Service
public class LoginService {

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    TbUserMapper userMapper;
    public ResultObject login(String username, String password,
                              HttpServletRequest request, HttpServletResponse response) {
        //校验用户名密码是否正确
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<TbUser> list=userMapper.selectByExample(example);
        //取用户信息
        if(list==null||list.isEmpty()){
            return ResultObject.build(400, "用户名或密码错误");
        }
        TbUser user=list.get(0);
        //校验密码
        if(!user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))){
            return ResultObject.build(400, "用户名或密码错误");
        }
        //登录成功，生成token
        String token = UUID.randomUUID().toString();
        //把用户信息写入redis
        //key:REDIS_SESSION:{TOKEN}
        //value:user转成json
        user.setPassword(null);
        System.out.println(user.toString());
        stringRedisTemplate.opsForValue().set("REDIS_SESSION_KEY" + ":"+token, JsonUtils.objectToJson(user));
        //jedisClient.set("REDIS_SESSION_KEY" + ":"+token, JsonUtils.objectToJson(user));
        //设置session过期时间
        //stringRedisTemplate.expire("REDIS_SESSION_KEY" + ":"+token,30, TimeUnit.MILLISECONDS);
        stringRedisTemplate.expire("REDIS_SESSION_KEY" + ":"+token,30, TimeUnit.MINUTES);
        //jedisClient.expire("REDIS_SESSION_KEY" + ":"+token, "SESSION_EXPIRE");
        String json = stringRedisTemplate.opsForValue().get("REDIS_SESSION_KEY" + ":"+token).toString();
        System.out.println("get:" + json);
        //写cookie
        CookieUtils.setCookie(request, response, "PSP_TOKEN", token);
        return ResultObject.ok(token);
    }
    public ResultObject getUserByToken(String token) {
        //根据token取用户信息
        String json = stringRedisTemplate.opsForValue().get("REDIS_SESSION_KEY" + ":"+token).toString();
        //String json = jedisClient.get("REDIS_SESSION_KEY" + ":"+token);
        //判断是否查询到结果
        if(StringUtils.isBlank(json)){
            return ResultObject.build(400, "用户session已过期");
        }
        //把json转换成java对象
        TbUser user = JsonUtils.jsonToPojo(json, TbUser.class);
        //更新session过期时间
        //jedisClient.expire("REDIS_SESSION_KEY" + ":"+token, "SESSION_EXPIRE");
        stringRedisTemplate.expire("REDIS_SESSION_KEY" + ":"+token,30, TimeUnit.MINUTES);
        return ResultObject.ok(user);
    }
}
