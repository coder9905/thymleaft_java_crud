//package uz.baxtiyor.swagger_token.security;
//Avtomat yoziwni ishlatish uchun
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.stereotype.Component;
//import uz.zako.online_test.entity.User;
//import uz.zako.online_test.service.HistoryService;
//
//import javax.persistence.EntityManager;
//import java.util.Optional;
//
//@Component("auditorAware")
//@RequiredArgsConstructor
//public class SecurityAuditorResolver implements AuditorAware<User> {
//    private final EntityManager entityManager;
//    private  final HistoryService historyService;
//
//    @Override
//    public Optional<User> getCurrentAuditor() {
//
//        User user=historyService.getByTokenUser();
//        if (user == null) {
//            return Optional.empty();
//        }
//        return Optional.ofNullable(user);
//    }
//
//
//}