package com.lin.springboot.pojo;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "city")
@Data
public class City implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    /*缺陷*/
    private String countryCode;
    private String district;
    private Integer population;

}
