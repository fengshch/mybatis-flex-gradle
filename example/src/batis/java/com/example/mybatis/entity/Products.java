package com.example.mybatis.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;

/**
 *  实体类。
 *
 * @author bill
 * @since 2024-05-30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("PRODUCTS")
public class Products implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Integer productId;

    private String productName;

    private String description;

    private BigDecimal price;

    private Integer stock;

    private Timestamp createdAt;

}
