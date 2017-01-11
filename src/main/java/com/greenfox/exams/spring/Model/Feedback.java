package com.greenfox.exams.spring.Model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Rita on 2017.01.11..
 */

@Entity
@Data
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(length = 3000)
    private String experience;
    private int scale;
    private String email;

}
