package com.example.school_system.dto;

import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "student")
public class User {
    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "reg_no")
    private Long id;
    private String username;
    private String password;

}
