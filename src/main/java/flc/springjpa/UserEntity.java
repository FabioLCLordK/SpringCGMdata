package flc.springjpa;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class UserEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @Column(columnDefinition = "Date")
    private LocalDate birthdate;
    private String email;
    private Integer followers;
    private boolean isActive;

    public UserEntity() {
    }

    public UserEntity(String firstname, String lastname, LocalDate birthdate, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.email = email;
        this.followers = 0;
        this.isActive = true;
    }

    public UserEntity(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = null;
        this.email = null;
        this.followers = 0;
        this.isActive = true;
    }

    
    
    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthDate() {
        return birthdate;
    }

    public void setBirthDate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "UserEntity{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", birthDate=" + birthdate + ", email=" + email + ", followers=" + followers + ", isActive=" + isActive + '}';
    }

    
}
