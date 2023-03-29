package flc.springjpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    //stringhe
    List<UserEntity> findByLastname(String lastname);
    List<UserEntity> findByFirstnameAndLastname(String firstname,String lastname);
    List<UserEntity> findByLastnameNot(String lastname);
    Optional<UserEntity> findByEmail (String email);
    List<UserEntity> findByLastnameOrderByBirthdate(String lastname);
    
    //booleani
    List<UserEntity> findByIsActive(Boolean isActive);
    List<UserEntity> findByIsActiveTrue();
    List<UserEntity> findByIsActiveFalse();
    
    //String like
    List<UserEntity> findByLastnameStartingWith(String startLastname);
    List<UserEntity> findByLastnameContaining(String infix);
    List<UserEntity> findByLastnameEndingWith(String suffix);
    
    //Integer
    List<UserEntity> findByFollowersLessThan(Integer follower);
    List<UserEntity> findByFollowersLessThanEqual(Integer follower);
    List<UserEntity> findByFollowersGreaterThan(Integer follower);
    List<UserEntity> findByFollowersGreaterThanEqual(Integer follower);
    
    //Date
    List<UserEntity> findByBirthdateAfter(LocalDate birthdate);
    List<UserEntity> findByBirthdateBefore(LocalDate birthdate);
}
