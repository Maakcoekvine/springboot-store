package com.coek.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-26 13:09:48
 */
@Data
public class Product extends BaseEntity{
    private Integer id;
    private Integer categoryId;
    private String itemType;
    private String title;
    private String sellPoint;
    private Long price;
    private Integer num;
    private String image;
    private Integer status;
    private Integer priority;

}
