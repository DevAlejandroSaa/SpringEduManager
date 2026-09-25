package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.service.PracticeEvaluationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/practice-evaluation")
@RequiredArgsConstructor
public class PracticeEvaluationController {

    @Qualifier("v1/PracticeEvaluationService")
    private final PracticeEvaluationService practiceEvaluationService;

}
