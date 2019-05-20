package com.hust.springbootsso.servcice;

import com.hust.springbootsso.entity.ResultObject;
import com.hust.springbootsso.mapper.TbUserMapper;
import com.hust.springbootsso.entity.TbUser;
import com.hust.springbootsso.model.TbUserExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class RegisterService {
    @Autowired
    TbUserMapper userMapper;
    public ResultObject checkData(String param, int type) {
        //根据数据类型检测数据
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        //1、2、3分别代表username,phone,email-->都不可重复
        if(1==type){
            criteria.andUserNameEqualTo(param);
        }else if (2==type) {
            criteria.andPhoneEqualTo(param);
        }else if (3==type) {
            criteria.andEmailEqualTo(param);
        }
        //执行查询
        List<TbUser> list = userMapper.selectByExample(example);
        //判断查询结果是否为空
        if(list==null||list.isEmpty()){
            return ResultObject.ok(true);
        }
        return ResultObject.ok(false);
    }
    public ResultObject register(TbUser user) {
        //校验数据
        //校验用户名密码不能为空
        if(StringUtils.isBlank(user.getUserName())||StringUtils.isBlank(user.getPassword())){
            return ResultObject.build(400, "用户名或密码不能为空");
        }
        //校验数据是否重复
        //校验用户名
        ResultObject result = checkData(user.getUserName(), 1);
        if(!(boolean) result.getData()){
            return ResultObject.build(400, "用户名重复");
        }
        //校验手机号
        if(user.getPhone()!=null){
            result=checkData(user.getPhone(), 2);
            if(!(boolean) result.getData()){
                return ResultObject.build(400, "手机号重复");
            }
        }
        //校验邮箱
        if(user.getEmail()!=null){
            result=checkData(user.getEmail(), 3);
            if(!(boolean) result.getData()){
                return ResultObject.build(400, "邮箱重复");
            }
        }
        //插入数据
        user.setCreated(new Date());
        user.setUpdated(new Date());
        //密码MD5加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userMapper.insert(user);
        return ResultObject.ok();
    }
}
