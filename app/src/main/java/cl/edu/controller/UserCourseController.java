package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.service.UserCourseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/user-course")
@RequiredArgsConstructor
public class UserCourseController {

    @Qualifier("v1/UserCourseService")
    private final UserCourseService courseService;

}
