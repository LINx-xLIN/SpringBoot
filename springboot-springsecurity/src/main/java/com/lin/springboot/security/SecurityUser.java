package com.lin.springboot.security;


import com.lin.springboot.pojo.BasicPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * 注意事项：用户名，密码，以及授权信息，是必须封装的。
 * 其他参数，可以根据需求放开
 */
public class SecurityUser implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    private List<BasicPermission> permissions;

    public List<BasicPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<BasicPermission> permissions) {
        this.permissions = permissions;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public SecurityUser(String password, Collection<? extends GrantedAuthority> authorities, String username) {
        this.password = password;
        this.authorities = authorities;
        this.username = username;
    }

    public SecurityUser() {

    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

