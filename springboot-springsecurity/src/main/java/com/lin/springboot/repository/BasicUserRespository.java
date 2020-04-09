package com.lin.springboot.repository;

import com.lin.springboot.pojo.BasicUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicUserRespository extends JpaRepository<BasicUser, Integer> {


    /**
     * 通过账号查询用户
     * @param userAccount
     * @return
     */
    BasicUser findByUserAccount(String userAccount);
}
