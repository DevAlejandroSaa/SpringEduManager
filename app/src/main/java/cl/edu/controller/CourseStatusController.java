package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.service.CourseStatusService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/course-status")
@RequiredArgsConstructor
public class CourseStatusController {

    @Qualifier("v1/CourseStatusService")
    private final CourseStatusService courseStatusService;

}
