package ua.fedii.superchat.service;

import ua.fedii.superchat.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    Contact findById(long id);
    Contact save(Contact contact);
    void deleteById(long id);
}
