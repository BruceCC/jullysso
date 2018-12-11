package org.zcm.julysso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Bruce Zhong
 */

@RestController
public class UserController {
    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }
}
