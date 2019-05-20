package com.hust.springbootsso.servcice;

import com.hust.springbootsso.entity.TbUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    public TbUser getUserByToken(HttpServletRequest request,
                                 HttpServletResponse response);
}
