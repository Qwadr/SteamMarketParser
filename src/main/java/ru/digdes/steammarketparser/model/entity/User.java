package ru.digdes.steammarketparser.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * "User" entity.
 * <p>
 * Describes all the fields of this entity.
 * Field "Password" must be changed, because only idiots
 * store passwords in their pure form.
 * <p>
 * userID - unique identifier;
 * login - so far there are no restrictions here, but maybe it will be changed;
 * email - speaks for itself;
 * password - now the password as it is, must be fixed;
 * registrationDate - speaks for itself.
 */
@Entity
@Data
@Table(name = "Users")
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
}
