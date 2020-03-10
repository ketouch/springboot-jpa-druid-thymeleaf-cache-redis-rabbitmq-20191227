package edu.nustti.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author LenmonCCC
 * @description
 * @create 2019/12/27  19:20
 */
@Entity
@Data
@Table
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 10)
    private String name;
    @Column(length = 11)
    private String phone;
    @Column
    private String email;
}
