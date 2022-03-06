package com.coek.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-20 14:30:45
 */
@Data
public class BaseEntity implements Serializable {


    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;

}
