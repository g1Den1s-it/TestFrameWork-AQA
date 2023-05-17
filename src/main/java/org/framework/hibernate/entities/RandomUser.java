package org.framework.hibernate.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "random_user")
@NoArgsConstructor
public class RandomUser implements Serializable {
    public RandomUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name = "username", length = 150, unique = true)
    private String username;
    @Column(name = "email", length = 254)
    private String email;
    @Column(name = "password", length = 128)
    private String password;
    @Column(name = "is_valid")
    private Boolean isValid = false;
}
