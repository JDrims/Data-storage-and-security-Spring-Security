package com.example.Hibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class Controller {
    @GetMapping("/read")
    @Secured("ROLE_READ")
    public String messageRead() {
        return "Read";
    }

    @GetMapping("/write")
    @RolesAllowed("ROLE_WRITE")
    public String messageWrite() {
        return "Write";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('ROLE_DELETE')")
    public String messageDelete() {
        return "Delete";
    }

    @GetMapping("/welcome")
    @PreAuthorize("#username == authentication.principal.username")
    public String messageWelcome(@RequestParam(value = "name", required = false) String username) {
        return "<h1>Welcome " + username + "</h1>";
    }
}
