package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.service.GradeRuleService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/grade-rule")
@RequiredArgsConstructor
public class GradeRuleController {

    @Qualifier("v1/GradeRuleService")
    private final GradeRuleService gradeRuleService;

}
