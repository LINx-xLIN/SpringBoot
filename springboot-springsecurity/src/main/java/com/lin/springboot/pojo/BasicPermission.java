package com.lin.springboot.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_basic_permission")
public class BasicPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer permissionId;
    private Integer modularId;
    private String permissionName;
    private String permissionAction;
    private String permissionWord;
    private Integer permissionParent;

}
