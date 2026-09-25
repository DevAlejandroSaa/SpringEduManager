package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.service.CourseEvaluationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/course-evaluation")
@RequiredArgsConstructor
public class CourseEvaluationController {

    @Qualifier("v1/CourseEvaluationService")
    private final CourseEvaluationService courseEvaluationService;

}
