package com.coek.domain;

import lombok.Data;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-28 09:50:22
 */
@Data
public class OrderItem extends BaseEntity {
    private Integer id;
    private Integer oid;
    private Integer pid;
    private String title;
    private String image;
    private Long price;
    private Integer num;

}
