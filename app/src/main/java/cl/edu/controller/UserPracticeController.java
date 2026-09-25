package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.service.UserPracticeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/user-practice")
@RequiredArgsConstructor
public class UserPracticeController {

    @Qualifier("v1/UserPracticeService")
    private final UserPracticeService userPracticeService;

}
