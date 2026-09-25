package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.service.CourseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/course")
@RequiredArgsConstructor
public class CourseController {

    @Qualifier("v1/CourseService")
    private final CourseService courseService;

}
