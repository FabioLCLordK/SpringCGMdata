package flc.springjpa;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;//collega all'interfaccia
    
    public void create(String firstname, String lastname){
        UserEntity user = new UserEntity(firstname,lastname);
        userRepository.save(user);
    }
    
    public void create(String firstname, String lastname, LocalDate birthdate, String email){
        UserEntity user = new UserEntity(firstname,lastname,birthdate,email);
        userRepository.save(user);
        
    }
    
    public void readAll(){
        for (var userEntity : userRepository.findAll()) {
            System.out.println(userEntity);
        }
    }
    
    public void readAll(int zeroIndexedPage, int pageSize){
        Page<UserEntity> users = userRepository.findAll(PageRequest.of(zeroIndexedPage, pageSize, Sort.by("lastname").ascending()));
        System.out.println("number of pages" + users.getTotalPages());
        System.out.println("number of elements" + users.getTotalElements());
        for (UserEntity userEntity : users) {
            System.out.println(userEntity);
        }
    }
    
    public void readByLastname(String lastname){
        for (var userEntity : userRepository.findByLastname(lastname)) {
            System.out.println(userEntity);
        }
    }
    
    public void readByFirstnameAndLastname(String firstname, String lastname){
        for (var userEntity : userRepository.findByFirstnameAndLastname(firstname,lastname)) {
            System.out.println(userEntity);
        }
    }
    
    public void read(Long id) {
        Optional<UserEntity> userEOptional = userRepository.findById(id);
        System.out.println(userEOptional);
    }
    
    public void readByNotLastname(String lastname){
        for (var userEntity : userRepository.findByLastnameNot(lastname)) {
            System.out.println(userEntity);
        }
    }
    
    public void readByIsActive(){
        for (var userEntity : userRepository.findByIsActiveTrue()) {
            System.out.println(userEntity);
        }
    }
    
    public void readByLastnameStartingWith(String lastname){
        for (var userEntity : userRepository.findByLastnameStartingWith(lastname)) {
            System.out.println(userEntity);
        }
    }
    
    public void readByLastnameContaining(String lastname){
        for (var userEntity : userRepository.findByLastnameContaining(lastname)) {
            System.out.println(userEntity);
        }
    }
    
    public void readByLastnameEndingWith(String lastname){
        for (var userEntity : userRepository.findByLastnameEndingWith(lastname)) {
            System.out.println(userEntity);
        }
    }
    
    public void ByFollwersLessThan(String lastname){
        for (var userEntity : userRepository.findByFollowersLessThan(100)) {
            System.out.println(userEntity);
        }
    }
    
    public void ByFollwersGreaterThan(String lastname){
        for (var userEntity : userRepository.findByFollowersGreaterThan(100)) {
            System.out.println(userEntity);
        }
    }
    public void increaseFollowersByLastname(String lastname, int followersadds){
        for (var userEntity : userRepository.findByLastname(lastname)) {
            int followersAtNow = userEntity.getFollowers();
            userEntity.setFollowers(followersAtNow + followersadds);
            userRepository.save(userEntity);
        }
    }
    public void readByEmail(String email){
        var userEntity = userRepository.findByEmail(email);
            System.out.println(userEntity);
        
    }
    public void readByLastnameOrderedByBirthdate(String lastname){
        for (var userEntity : userRepository.findByLastnameOrderByBirthdate(lastname)) {
            System.out.println(userEntity);
        }
    }
    
    public void readByBirthdateAfter(LocalDate birthdate){
        for (var userEntity : userRepository.findByBirthdateAfter(birthdate)){
            System.out.println(userEntity);
        }       
    }
    
    public void readByBirthdateBefore(LocalDate birthdate){
        for (var userEntity : userRepository.findByBirthdateBefore(birthdate)){
            System.out.println(userEntity);
        }       
    }
    
}
