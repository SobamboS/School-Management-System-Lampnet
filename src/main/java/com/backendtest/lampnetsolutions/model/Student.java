package com.backendtest.lampnetsolutions.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Getter
@Setter
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student{

    @Id
    @Column
    @GeneratedValue(generator = "seq",strategy= GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message="Field cannot be blank")
    private String firstName;
    @NotBlank(message="Field cannot be blank")
    private String lastName;
    @NotBlank(message="Field cannot be blank")
    private String password;
    @Column(nullable = false, unique = true)
    @Email(message="Input a valid email address")
    private String email;

    @NotBlank(message="Field cannot be blank")
    private Integer grade;

    public Student(String firstName,String lastName,String password,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
        this.email=email;
    }
}
