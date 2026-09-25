package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/refresh-token")
@RequiredArgsConstructor
public class RefreshTokenController {

    @Qualifier("v1/RefreshTokenService")
    private final RefreshTokenService refreshTokenService;

}
