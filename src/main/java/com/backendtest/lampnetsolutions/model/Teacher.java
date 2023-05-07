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
public class Teacher{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    @NotBlank
    private String firstName;

    @NotBlank
    @Column(nullable=false)
    private String lastName;

    @NotBlank
    @Column(nullable=false)
    @Email(message="Input a valid email")
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;


    public Teacher(String firstName,String lastName,String email,String password){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
    }
}
