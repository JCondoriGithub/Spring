package com.example.demoJwtSecurity.controller;

import com.example.demoJwtSecurity.model.Contact;
import com.example.demoJwtSecurity.repository.ContactRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contacts")
public class ContactController {
    
    @Autowired
    private ContactRepository contactRepo;
    
    @RequestMapping
    public List<Contact> listcontact() {
        return contactRepo.findAll();
    }
}
