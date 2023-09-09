package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false,unique = true,columnDefinition = "varchar(100)")
    private String email;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "avartar",nullable = false)
    private String avatar;

    @JsonIgnore
    @Column(name = "passwowd",nullable = false)
    private String password;
}
