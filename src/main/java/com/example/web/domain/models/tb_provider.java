package com.example.web.domain.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_provider")
public class tb_provider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "EIN")
    private String EIN;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "celphone")
    private String celphone;
    @Column(name = "zipcode")
    private String zipcode;
    @Column(name = "address")
    private String address;
    @Column(name = "number")
    private int number;
    @Column(name = "complement")
    private String complement;
    @Column(name = "neighborhood")
    private String neighborhood;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
}
