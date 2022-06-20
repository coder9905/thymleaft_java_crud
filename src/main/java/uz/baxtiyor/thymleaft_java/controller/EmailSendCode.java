package uz.baxtiyor.thymleaft_java.controller;//package uz.zako.online_test.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//import uz.zako.online_test.config.DateConfig;
//import uz.zako.online_test.entity.ConfirmCode;
//import uz.zako.online_test.entity.User;
//import uz.zako.online_test.model.Result;
//import uz.zako.online_test.repository.ConfirmCodeRepository;
//import uz.zako.online_test.repository.UserRepository;
//
//import java.util.Random;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/auth")
//public class EmailSendCode {
//
//    private final ConfirmCodeRepository confirmCodeRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
//    private final UserRepository userRepository;
//    private final DateConfig dateConfig;
//    private final JavaMailSender emailSender;
//    private final Logger logger= LoggerFactory.getLogger(AuthController.class);
//
//    @Value("${spring.mail.username}")
//    private String emailFrom;
//
//    @PostMapping("/forgot-password")
//    public ResponseEntity forgotPassword(@RequestParam String username) {
//        User user = userRepository.findByUsername(username);
//        Random random = new Random();
//        //0-999999
//        //100000-999999
//        String code = String.valueOf(random.nextInt(999999 - 100000) + 100000);
//        ConfirmCode confirmCode = new ConfirmCode();
//        confirmCode.setCode(code);
////        confirmCode.setFinalDate(dateConfig.convertToDateViaSqlTimestamp(dateConfig.convertToLocalDateTimeViaInstant(new Date()).plusMinutes(5)));
//        confirmCode.setUser(user);
//        System.out.println(confirmCode);
//        ConfirmCode confirmC = confirmCodeRepository.save(confirmCode);
//        if (confirmC == null) {
//            return new ResponseEntity(new Result(false, "something wrong. please try again", null), HttpStatus.BAD_REQUEST);
//        }
//
//        try {
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setFrom(emailFrom);
//            message.setTo(user.getUsername());
//            message.setSubject("This message for Forgotten Password");
//            message.setText(confirmC.getCode());
//            emailSender.send(message);
//            logger.info("code is sending -{} - {} ",confirmC.getCode(), user.getUsername());
//        }catch ( Exception e){
//            logger.error(e.getMessage());
//        }
//        return ResponseEntity.ok(new Result(true,"code is sending",confirmC));
//    }
//
//    @PostMapping("/check-code/{username}")
//    public ResponseEntity<?> chechCode(@PathVariable String username, @RequestParam String code){
//        User user=userRepository.findByUsername(username);
//        ConfirmCode confirmCode=confirmCodeRepository.findByUser(user.getId());
//        if (confirmCode==null){
//            return new ResponseEntity(new Result(false,"not found",null), HttpStatus.BAD_REQUEST);
//        }
//        return ResponseEntity.ok(new Result(true,"succesfull code",confirmCode));
//    }
//
//    //postmanda tekshirishda ?password=editedPass
//    @PostMapping("/reset-password/{username}")
//    public ResponseEntity<?> resetPassword(@PathVariable String username, @RequestParam String password){
//        User user=userRepository.findByUsername(username);
//        user.setPassword(passwordEncoder.encode(password));
//        User user1=userRepository.save(user);
//
//        if (user1==null){
//            return new ResponseEntity(new Result(false,"sww",null), HttpStatus.BAD_REQUEST);
//        }
//        return ResponseEntity.ok(new Result(true,"succesfull code",user));
//    }
//}
