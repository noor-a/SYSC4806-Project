package models;

import javax.persistence.Entity;

@Entity
public class Submitter extends User{

    public Submitter(){
        this.setRole(Role.SUMBITTER);
    }
}
