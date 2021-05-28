package tw.com.rex.resourceserver.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
public class TestController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/principal")
    public AuthenticatedPrincipal principal(@AuthenticationPrincipal OAuth2AuthenticatedPrincipal principal) {
        return principal;
    }

}
