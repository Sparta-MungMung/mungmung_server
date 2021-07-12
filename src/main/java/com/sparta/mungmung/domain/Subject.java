package com.sparta.mungmung.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Subject {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long subjectId;

    @Column(nullable = false)
    private String subjectName;
}
