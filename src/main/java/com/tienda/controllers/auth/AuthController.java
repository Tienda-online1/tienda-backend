package com.tienda.controllers.auth;

import com.tienda.domain.dtos.LoginDto;
import com.tienda.domain.dtos.UserRequestDto;
import com.tienda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(userService.login(loginDto));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registro(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.register(userRequestDto));
    }
}
