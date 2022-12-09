package com.paymentsystem.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "name_of_street")
    private String nameOfStreet;

    @Column(name = "number_of_building")
    private String numberOfBuilding;

    @Column(name = "post_code")
    private String postCode;

    @OneToOne(mappedBy = "address")
    private Customer customer;
}