package com.lin.springboot.pojo;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tb_basic_role")
public class BasicRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String roleName;
    private String rolePermissions;
    @Transient
    private List<BasicPermission> permissions;
}
