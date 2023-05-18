package org.framework.hibernate.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "comment")
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name = "manga")
    private String manga;
    @Column(name = "author")
    private String author;
    @Column(name = "body")
    private String body;
    @Column(name = "is_valid")
    private Boolean isValid = false;
}
