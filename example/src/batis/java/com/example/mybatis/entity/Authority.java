package com.example.mybatis.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  实体类。
 *
 * @author bill
 * @since 2023-09-11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "authority")
public class Authority implements Serializable {

    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String name;

    private Integer user;

}
