package ru.digdes.steammarketparser.dto;

import lombok.Data;
import ru.digdes.steammarketparser.model.entity.User;

import javax.persistence.Entity;
import java.util.Date;

/**
 * TODO javadoc
 */
@Entity
@Data
public class UserDTO {
    private long userID;

    private String login;

    private String email;

    private String password;

    private Date registrationDate;

    public UserDTO(User user) {
        this.userID =           user.getUserID();
        this.login =            user.getLogin();
        this.email =            user.getEmail();
        this.password =         user.getPassword();
        this.registrationDate = user.getRegistrationDate();
    }
}
