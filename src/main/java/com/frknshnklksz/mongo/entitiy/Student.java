package com.frknshnklksz.mongo.entitiy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "STUDENT")
public class Student {
    @Id
    private Integer id;
    private String name;
    private String surName;
    private String identityNumber;
    private String email;
    private String city;

}
