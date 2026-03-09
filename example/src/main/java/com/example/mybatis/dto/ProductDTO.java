package com.example.mybatis.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;

    private String name;

    private String price;

    private String currency;
}
