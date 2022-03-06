package com.coek.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-20 14:35:27
 */
@Data
public class User extends BaseEntity implements Serializable {

    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private Integer isDelete;


}
