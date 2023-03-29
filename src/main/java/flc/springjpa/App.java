package flc.springjpa;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author LordKazor
 */
public class App {
    public static void main(String[] args) {
        
        ApplicationContext ctx= new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = ctx.getBean(UserService.class);  

        userService.create("Eric", "Cartman",LocalDate.of(2003, Month.FEBRUARY, 25),"1@gmail.com"); 
        userService.create("Stan", "Marsh",LocalDate.of(2003, Month.MARCH, 25),"2@gmail.com"); 
        userService.create("Kenny", "McCormick",LocalDate.of(2003, Month.APRIL, 25),"3@gmail.com"); 
        userService.create("Kyle", "Broflowsky",LocalDate.of(2013, Month.AUGUST, 5),"4@gmail.com"); 
        userService.create("Mr", "Garrison"); 
        userService.create("Signor", "Mason");
        userService.create("Preside", "PC");
        userService.create("Gerard", "Broflowsky"); 
        userService.create("Ike", "Broftowsky"); 
        userService.create("Mr", "Chef"); 
        userService.create("Agende", "Barbrady"); 
        userService.readAll(); 

        //userService.readAll(0, 10);
        //userService.read(1L);
        
        //LocalDate.of(2003, Month.FEBRUARY, 25)
       userService.readByBirthdateAfter(LocalDate.of(2003, Month.FEBRUARY, 25));
} 

}
