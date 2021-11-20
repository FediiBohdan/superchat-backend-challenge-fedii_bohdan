package ua.fedii.superchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.fedii.superchat.model.Contact;
import ua.fedii.superchat.service.ContactService;

@RestController
@RequestMapping("/api")
public class ContactRestController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(contactService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/contacts/{contactId}")
    public ResponseEntity<?> getContact(@PathVariable long contactId) {
        return new ResponseEntity<>(contactService.findById(contactId), HttpStatus.OK);
    }

    @PostMapping("/contacts")
    public ResponseEntity<?> newContact(@RequestBody Contact newContact) {
        newContact.setId(0);

        return new ResponseEntity<>(contactService.save(newContact), HttpStatus.OK);
    }

    @PutMapping("/contacts")
    public ResponseEntity<?> updateContact(@RequestBody Contact updatedContact) {
        return new ResponseEntity<>(contactService.save(updatedContact), HttpStatus.OK);
    }

    @DeleteMapping("/contacts/{contactId}")
    public ResponseEntity<?> deleteContact(@PathVariable long contactId) {
        contactService.deleteById(contactId);
        return ResponseEntity.status(200).body("Contact deleted successfully!");
    }
}