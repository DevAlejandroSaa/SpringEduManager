package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.service.CourseClassService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/course-class")
@RequiredArgsConstructor
public class CourseClassController {

    @Qualifier("v1/CourseClassService")
    private final CourseClassService courseClassService;

}
