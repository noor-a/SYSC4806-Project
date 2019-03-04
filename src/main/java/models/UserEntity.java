package models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min=1, max=32)
    @Column(unique = true)
    private String username;

    @Size(min=8)
    private String password;
}
