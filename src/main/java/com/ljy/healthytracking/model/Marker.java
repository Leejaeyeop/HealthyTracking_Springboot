package com.ljy.healthytracking.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Marker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private Float x;
    @Column
    private Float y;
    @Column
    private Float alt;

}
