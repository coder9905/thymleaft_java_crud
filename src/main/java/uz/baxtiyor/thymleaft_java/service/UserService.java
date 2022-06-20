package uz.baxtiyor.thymleaft_java.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import uz.baxtiyor.thymleaft_java.payload.UserPayload;

public interface UserService {

    ResponseEntity<?> saveUser(@RequestBody UserPayload payload);
}
