package com.cocanTest.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto {

    private String nom;

    private String prenoms;

    private String email;

    private String contact;

    private String motdepasse;

    private String photo;

}
