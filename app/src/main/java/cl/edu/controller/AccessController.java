package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.service.AccessService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/access")
@RequiredArgsConstructor
public class AccessController {

    @Qualifier("v1/AccessService")
    private final AccessService accessService;

}
