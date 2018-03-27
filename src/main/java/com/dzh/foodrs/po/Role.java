package com.dzh.foodrs.po;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

/**
 * Created by holyfrans on 2017/3/6.
 * ½ÇÉ«±í
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15)
    @Size(max = 15)
    private String roleName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}