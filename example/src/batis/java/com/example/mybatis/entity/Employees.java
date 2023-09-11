package com.example.mybatis.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
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
@Table(value = "employees")
public class Employees implements Serializable {

    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private Date dateOfBirth;

    private Timestamp hiredDate;

}
