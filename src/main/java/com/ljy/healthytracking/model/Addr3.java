package com.ljy.healthytracking.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Addr3 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String addr3;
}
