package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.service.AccessTokenService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/access-token")
@RequiredArgsConstructor
public class AccessTokenController {

    @Qualifier("v1/AccessTokenService")
    private final AccessTokenService accessTokenService;

}
