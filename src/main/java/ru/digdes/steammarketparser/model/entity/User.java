package ru.digdes.steammarketparser.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * "User" entity.
 * Describes all the fields of this entity.
 * Field "Password" must be changed, because only idiots
 * store passwords in their pure form.
 */
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private long userID;

    @Column(name = "Login", nullable = false)
    private String login;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "RegistrationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    public User() {
    }


    public String getLogin() {
        return login;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public long getUserID() {
        return userID;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
