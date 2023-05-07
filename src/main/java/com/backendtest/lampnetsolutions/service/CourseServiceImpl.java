package com.backendtest.lampnetsolutions.service;

import com.backendtest.lampnetsolutions.dto.CreateCourseRequest;
import com.backendtest.lampnetsolutions.exception.CourseException;
import com.backendtest.lampnetsolutions.model.Course;
import com.backendtest.lampnetsolutions.repository.CourseRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@NoArgsConstructor
public class CourseServiceImpl implements CourseService{
   CourseRepository courseRepository;

    public String createCourse(CreateCourseRequest createCourseRequest)throws CourseException{
        var findCourse = courseRepository.findByCourseCode(createCourseRequest.getCourseCode());
              if(findCourse.isPresent())
                  throw new CourseException(String.format("%s has been assigned to another course", findCourse));
        Course course = new Course(
                createCourseRequest.getCourseName(),
                createCourseRequest.getDescription(),
                createCourseRequest.getCourseCode());
        courseRepository.save(course);
        return ("Course created");
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }



    public Course updateCourse(Course course) throws CourseException{
        var findCourse = courseRepository.findById(course.getId())
                .orElseThrow(()-> new CourseException("Course not found"));
        if (findCourse != null) {
            findCourse.setCourseName(course.getCourseName());
            findCourse.setDescription(course.getDescription());
            findCourse.setCourseCode(course.getCourseCode());
            return courseRepository.save(findCourse);
        } else {
            return null;
        }
    }


    public String deleteCourse(Long id) {
    courseRepository.deleteById(id);
    return ("Deleted");
    }
}
