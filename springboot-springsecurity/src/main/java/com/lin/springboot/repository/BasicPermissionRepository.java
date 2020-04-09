package com.lin.springboot.repository;

import com.lin.springboot.pojo.BasicPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicPermissionRepository extends JpaRepository<BasicPermission, Integer> {

    /**
     * 通过编号数据查询多个权限，JPQL支持数据以及集合参数
     * @param permissionIds
     * @return
     */
    @Query(value = "SELECT p from BasicPermission p WHERE p.permissionId in (:permissionIds)")
    List<BasicPermission> findByPermissionIds(Object[] permissionIds);
}
