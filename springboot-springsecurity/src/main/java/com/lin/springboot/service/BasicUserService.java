package com.lin.springboot.service;

import com.lin.springboot.pojo.BasicUser;

public interface BasicUserService {

    /**
     * 查询用户信息通过账号名
     * @param userAccount
     * @return
     */
    BasicUser findUserByAccount(String userAccount);


    /**
     * 通过账号名，将用户的所有信息一次全部查询处理
     * @param userAccount
     * @return
     */
    BasicUser findUserAllByAccount(String userAccount);
}
