package ru.digdes.steammarketparser.model.entity;

import javax.persistence.*;
import java.sql.Date;

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

    @Column(name = "RegistrationDate")
    private Date registrationDate;

    public User() {
    }

    public long getUserID() {
        return userID;
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


}
