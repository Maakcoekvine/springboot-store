package com.coek.domain;

import lombok.Data;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-26 21:29:21
 */
@Data
public class Cart extends BaseEntity {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;
}
