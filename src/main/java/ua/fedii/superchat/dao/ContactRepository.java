package ua.fedii.superchat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.fedii.superchat.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
