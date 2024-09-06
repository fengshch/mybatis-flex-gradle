package com.example.mybatis.po;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import java.io.Serial;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  实体类。
 *
 * @author bill
 * @since 2024-09-06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("ORDERS")
public class OrdersPo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Integer orderId;

    private Integer userId;

    private Timestamp orderDate;

    private BigDecimal totalAmount;

}