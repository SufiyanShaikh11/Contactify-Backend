package com.contactmanager;

import com.contactmanager.model.Contact;
import com.contactmanager.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ContactRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                Contact contact = new Contact();
                contact.setName("Sufiyan Shaikh");
                contact.setPhone("9867117620");
                contact.setEmail("srsufiyan1@gmail.com");
                contact.setPosition("FullStack Developer");
                contact.setActive(true);
                repo.save(contact);
            }
        };
    }
}
