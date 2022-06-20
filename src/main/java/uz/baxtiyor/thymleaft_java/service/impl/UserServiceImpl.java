package uz.baxtiyor.thymleaft_java.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import uz.baxtiyor.thymleaft_java.entity.User;
import uz.baxtiyor.thymleaft_java.model.Result;
import uz.baxtiyor.thymleaft_java.payload.UserPayload;
import uz.baxtiyor.thymleaft_java.repository.RoleRepository;
import uz.baxtiyor.thymleaft_java.repository.UserRepository;
import uz.baxtiyor.thymleaft_java.service.UserService;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public ResponseEntity<?> saveUser(@RequestBody UserPayload payload){
        try {
            User user = new User();
            user.setUsername(payload.getUsername());
            user.setFullName(payload.getFullName());
            user.setPassword(bCryptPasswordEncoder.encode(payload.getPassword()));
            user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
            user.setIsAdmin(payload.getIsAdmin());

            user=userRepository.save(user);

            if (user != null){
                return ResponseEntity.ok(new Result(true,"save user succesfull",user));
            }
            return new ResponseEntity(new Result(false,"save error user",null), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            log.error("user save error",e.getMessage());
            return new ResponseEntity(new Result(false,"save error user",null), HttpStatus.BAD_REQUEST);
        }

    }

}
