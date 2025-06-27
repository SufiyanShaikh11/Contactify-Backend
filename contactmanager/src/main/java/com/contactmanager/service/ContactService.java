package com.contactmanager.service;

import com.contactmanager.model.Contact;
import com.contactmanager.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repo;

    public List<Contact> getAll(String search) {
        if (search != null && !search.isEmpty()) {
            return repo.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContainingIgnoreCase(
                    search, search, search
            );
        }
        return repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Contact save(Contact contact) {
        return repo.save(contact);
    }

    public Optional<Contact> get(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
