package com.backendtest.lampnetsolutions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course{
    @Id
    @GeneratedValue(generator = "seq",strategy= GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message="Field cannot be blank")
    private String courseName;
    @NotBlank(message="Field cannot be blank")
    private String description;
    @NotBlank(message="Field cannot be blank")
    @Pattern(regexp="^\\d+$")
    private int courseCode;

    public Course(String course_name,String description, int courseCode){
        this.courseName=course_name;
        this.description=description;
        this.courseCode=courseCode;
    }
}


