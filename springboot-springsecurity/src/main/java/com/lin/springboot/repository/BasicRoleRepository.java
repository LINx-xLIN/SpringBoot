package com.lin.springboot.repository;

import com.lin.springboot.pojo.BasicRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicRoleRepository extends JpaRepository<BasicRole, Integer> {

    /**
     * 通过编号查询角色
     * @param roleId
     * @return
     */
    BasicRole findByRoleId(Integer roleId);
}
