package com.coek.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-28 09:47:45
 */
@Data
public class Order extends BaseEntity {
    private Integer oid;
    private Integer uid;
    private String recvName;
    private String recvPhone;
    private String recvProvince;
    private String recvCity;
    private String recvArea;
    private String recvAddress;
    private Long totalPrice;
    private Integer status;
    private Date orderTime;
    private Date payTime;

}
