package com.example.demoJwtSecurity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Contact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcontact")
    private Integer id;
    
    private String name;
    
    @Column(name = "data-birth")
    private String dateBirth;
    
    private String telephone;    
    private String email;

    public Contact() {
    }

    public Contact(Integer id, String name, String dateBirth, String telephone, String email) {
        this.id = id;
        this.name = name;
        this.dateBirth = dateBirth;
        this.telephone = telephone;
        this.email = email;
    }
    
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", name=" + name + ", dateBirth=" + dateBirth + ", telephone=" + telephone + ", email=" + email + '}';
    }
    
}
