package com.coek.vo;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-27 18:07:38
 */

import lombok.Data;

/**
 * 用于展示购物车信息的VO
 */
@Data
public class CartVO {

    private String title;
    private String image;
    private Long price;
    private Integer num;
    private Integer pid;
    private Integer uid;
    private Integer cid;
    private Long allPrice;
    private Integer allCount;
}
