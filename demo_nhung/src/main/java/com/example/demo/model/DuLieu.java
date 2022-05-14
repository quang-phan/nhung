package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tblcambien")
@Data
public class DuLieu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String doAm;
    @Column(nullable = false)
    private String nhietDo;
    @Column(nullable = false)
    private String giaTri;
    @Column(nullable = false)
    private String thoiGian;
}
