package ua.fedii.superchat.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.fedii.superchat.dao.ContactRepository;
import ua.fedii.superchat.model.Contact;
import ua.fedii.superchat.service.ContactService;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(long id) {
        Optional<Contact> tempContact = contactRepository.findById(id);

        Contact contact;

        if (tempContact.isPresent()) {
            contact = tempContact.get();
        } else {
            throw new RuntimeException("Did not find contact by id: " + id);
        }

        return contact;
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteById(long id) {
        Optional<Contact> tempContact = contactRepository.findById(id);

        if (tempContact.isPresent()) {
            contactRepository.deleteById(id);
        } else {
            throw new RuntimeException("Did not find contact by id: " + id);
        }
    }

    @Override
    public long checkContactPlaceholder(String messageContent) {
        final Pattern contactPattern = Pattern.compile("(?!(?i)@btc)(?!(?i)@bitcoin)([@][A-za-z0-9]+)");

        Matcher matcher = contactPattern.matcher(messageContent);
        String name = null;

        if (matcher.find()) {
            name = matcher.group(1);
        }

        assert name != null;
        return contactRepository.findFirstByContactNameIgnoreCaseContaining(name.substring(1)).getId();
    }
}