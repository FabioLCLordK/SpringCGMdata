
package flc.springjpa;

import java.time.LocalDate;
import java.time.Month;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringData {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //context.getBean(UserService.class).create("Peter", "Parker");
        
        var userService = context.getBean(UserService.class);
        userService.create("Peter", "Parker", LocalDate.of(1990, Month.MARCH, 12), "spiderman@google.com");
        userService.create("Maurizio", "Mastropasqua", LocalDate.of(1990, Month.JUNE, 28), "mauizio90@google.com");
        userService.create("Wade", "Wilson", LocalDate.of(1990, Month.JUNE, 15), "deadpool@google.com");
        userService.create("Reed", "Richards", LocalDate.of(1988, Month.APRIL, 30), "mrfantastic@google.com");
        userService.create("Carlo", "Cracco", LocalDate.of(1980, Month.JANUARY, 6), "cracco@google.com");
        userService.create("Bruce", "Banner", LocalDate.of(1990, Month.MAY, 12), "hulk@google.com");
        userService.create("Miles", "Morales", LocalDate.of(2001, Month.JUNE, 12), "spiderman2@google.com");
        userService.create("Stan", "Lee", LocalDate.of(1952, Month.JULY, 12), "stanlee@google.com");
        userService.create("Matt", "Murdock", LocalDate.of(1990, Month.AUGUST, 12), "daredavil@google.com");
        userService.create("Tony", "Stark", LocalDate.of(1990, Month.SEPTEMBER, 12), "ironman@google.com");
        userService.create("Ben", "Parker", LocalDate.of(1950, Month.OCTOBER, 12), "uncleben@google.com");
        userService.create("May", "Parker", LocalDate.of(1950, Month.MAY, 12), "ziamay@google.com");
//        userService.readAll();
//        userService.read(2L);
//        userService.readAll(0, 10);
//        userService.readByLastname("parker");
//        userService.readByFirstnameAndLastname("tony","stark");
//        userService.readByNotLastname("parker");
//        userService.readByIsActive();
//        userService.readByLastnameContaining("ark");
//        userService.increaseFollowersByLastname("parker", 1000);
//        userService.readAll();
//        userService.readByEmail("ironmerd@google.com");
        userService.readByLastnameOrderedByBirthdate("parker");
    }
}
