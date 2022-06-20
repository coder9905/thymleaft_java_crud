package uz.baxtiyor.thymleaft_java.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import uz.baxtiyor.thymleaft_java.entity.User;
import uz.baxtiyor.thymleaft_java.model.Result;
import uz.baxtiyor.thymleaft_java.payload.UserPayload;
import uz.baxtiyor.thymleaft_java.repository.UserRepository;
import uz.baxtiyor.thymleaft_java.security.JwtTokenProvider;
import uz.baxtiyor.thymleaft_java.security.SecurityUtils;
import uz.baxtiyor.thymleaft_java.service.UserService;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final SecurityUtils securityUtils;

    @PostMapping("/token")
    public ResponseEntity<?> getToken(@RequestBody UserPayload payload) {

        if (true) {
            User user = userRepository.findByUsername(payload.getUsername());
            System.out.println(user.toString());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(payload.getUsername(), payload.getPassword()));
            String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
            System.out.println(token.toString());
            if (token == null) {
                return new ResponseEntity(new Result(false, "error", null), HttpStatus.BAD_REQUEST);
            }
            Map<String, Object> map = new HashMap();
            map.put("token", token);
            map.put("username", true);
            return ResponseEntity.ok(map);
        }
        return ResponseEntity.ok(new Result(false, "error", null));

    }


}
