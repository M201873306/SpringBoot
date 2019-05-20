package com.hust.springbootsecurity.service;

import com.hust.springbootsecurity.entity.SysRole;
import com.hust.springbootsecurity.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }
    public SysRole selectByName(String name){
        return roleMapper.selectByName(name);
    }
}

