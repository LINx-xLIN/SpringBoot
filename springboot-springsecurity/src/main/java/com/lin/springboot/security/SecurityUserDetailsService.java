package com.lin.springboot.security;

import com.lin.springboot.pojo.BasicPermission;
import com.lin.springboot.pojo.BasicRole;
import com.lin.springboot.pojo.BasicUser;
import com.lin.springboot.security.SecurityUser;
import com.lin.springboot.service.BasicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private BasicUserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //第一步：构建返回的对象
        SecurityUser securityUser = new SecurityUser();
        //第二步：获得数据
        //获得系统用户信息
        BasicUser user = userService.findUserAllByAccount(username);
        //获得权限信息
        List<GrantedAuthority> authorities = new ArrayList<>();

        BasicRole role = user.getRole();

        if (role != null) {
            List<BasicPermission> permissions = role.getPermissions();
            for (BasicPermission permission : permissions) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission.getPermissionWord());
                authorities.add(authority);
            }

            //设置自定数据
            securityUser.setPermissions(permissions);

        }

        //第三步：封装数据
        securityUser.setUsername(user.getUserAccount());
        securityUser.setPassword(user.getUserPassword());
        securityUser.setAuthorities(authorities);

        //第四步：返回数据

        return securityUser;
    }
}
