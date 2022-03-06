package com.coek.domain;

import lombok.Data;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-24 16:54:07
 */
@Data
public class Address extends BaseEntity {
    private Integer aid;
    private Integer uid;
    private String name;
    private String provinceName;
    private String provinceCode;
    private String cityName;
    private String cityCode;
    private String areaName;
    private String areaCode;
    private String zip;
    private String address;
    private String phone;
    private String tel;
    private String tag;
    private Integer isDefault;

}
