package com.coek.domain;

import lombok.Data;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-24 18:33:59
 */
@Data
public class District {
    private Integer id;
    private String parent;
    private String code;
    private String name;

}
