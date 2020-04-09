package com.lin.springboot.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_basic_modular")
public class BasicModular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer modularId;
    private String modularName;
    private Integer modularSort;


}
