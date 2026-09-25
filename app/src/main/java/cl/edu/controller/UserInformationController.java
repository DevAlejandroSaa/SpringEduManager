package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.service.UserInformationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/user-information")
@RequiredArgsConstructor
public class UserInformationController {

    @Qualifier("v1/UserInformationService")
    private final UserInformationService userInformationService;

}
