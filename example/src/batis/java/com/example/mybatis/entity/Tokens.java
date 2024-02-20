package com.example.mybatis.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;

/**
 *  实体类。
 *
 * @author bill
 * @since 2024-02-20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "tokens")

public class Tokens implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String identifier;

    private String token;

}
