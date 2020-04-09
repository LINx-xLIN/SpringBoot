package com.lin.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_basic_user")
public class BasicUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userAccount;
    private Integer userStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//接收参数格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//json返回格式
    private Date userCreateDate;
    private Integer roleId;
    @Transient//忽略数据库关联
    private BasicRole role;
}
