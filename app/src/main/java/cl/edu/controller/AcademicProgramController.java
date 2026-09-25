package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.service.AcademicProgramService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/academic-program")
@RequiredArgsConstructor
public class AcademicProgramController {

    @Qualifier("v1/AcademicProgramService")
    private final AcademicProgramService academicProgramService;

}
