package com.lin.springboot.service.impl;

import com.lin.springboot.pojo.BasicPermission;
import com.lin.springboot.pojo.BasicRole;
import com.lin.springboot.pojo.BasicUser;
import com.lin.springboot.repository.BasicPermissionRepository;
import com.lin.springboot.repository.BasicRoleRepository;
import com.lin.springboot.repository.BasicUserRespository;
import com.lin.springboot.service.BasicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicUserServiceImpl implements BasicUserService {

    @Autowired
    private BasicUserRespository basicUserRespository;

    @Autowired
    private BasicRoleRepository basicRoleRepository;

    @Autowired
    private BasicPermissionRepository basicPermissionRepository;


    @Override
    public BasicUser findUserByAccount(String userAccount) {
        return basicUserRespository.findByUserAccount(userAccount);
    }

    @Override
    public BasicUser findUserAllByAccount(String userAccount) {
        //第一步：创建返回对象
        BasicUser basicUser = basicUserRespository.findByUserAccount(userAccount);

        if (basicUser != null) {
            //第二步：获得角色信息
            BasicRole role = basicRoleRepository.findByRoleId(basicUser.getRoleId());
            String[] rolePermissions = role.getRolePermissions().split(",");
            //第三步：获得权限信息
            Integer[] ids = this.stringStrToIntegers(rolePermissions);

            List<BasicPermission> permissions = basicPermissionRepository.findByPermissionIds(ids);
            role.setPermissions(permissions);
            basicUser.setRole(role);

        }

        //第四步：返回用户
        return basicUser;
    }


    /**
     * 字符串数组转数据类型数组
     * @param arrs
     * @return
     */
    private Integer[] stringStrToIntegers(String[] arrs) {
        Integer[] ints = new Integer[arrs.length];
        for (int i = 0; i < arrs.length; i++) {
            ints[i] = Integer.parseInt(arrs[i]);
        }
        return ints;
    }
}
