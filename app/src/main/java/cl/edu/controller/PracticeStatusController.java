package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.service.PracticeStatusService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/practice-status")
@RequiredArgsConstructor
public class PracticeStatusController {

    @Qualifier("v1/PracticeStatusService")
    private final PracticeStatusService practiceStatusService;

}
