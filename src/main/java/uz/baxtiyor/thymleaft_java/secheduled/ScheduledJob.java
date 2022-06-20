package uz.baxtiyor.thymleaft_java.secheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

// Biz korsatgan vaqtda bitta amalni bajarib turadi

@Component
public class ScheduledJob {

    //fixedDelay funksiya yakunlangandan kn wuncha vaqt o'tib qaytaradi
//    @Scheduled(fixedDelay = 1000)
//    void work(){
//        System.out.println(new Date());
//    }
//
//    //fixedRate funksiya biz korsatgan vaqtda tugallanmasa ham davom etaveradi
//    @Scheduled(fixedRate = 1000)
//    void work1() throws InterruptedException{
//        Thread.sleep(5000);
//        System.out.println(new Date());
//    }

    // initialDelay wuncha vaqt kutadi va fixedRate vaqtcha takrorlanadi
    @Scheduled(initialDelay = 10000L, fixedRate = 1000L)
    void work2() throws InterruptedException{
        Thread.sleep(5000);
        System.out.println(new Date());
    }

}
