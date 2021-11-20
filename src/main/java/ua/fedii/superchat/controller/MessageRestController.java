package ua.fedii.superchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.fedii.superchat.model.Contact;
import ua.fedii.superchat.model.Message;
import ua.fedii.superchat.service.ContactService;
import ua.fedii.superchat.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageRestController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private ContactService contactService;

    @GetMapping("/messages")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(messageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/messages/{messageId}")
    public ResponseEntity<?> getMessage(@PathVariable long messageId) {
        return new ResponseEntity<>(messageService.findById(messageId), HttpStatus.OK);
    }

    @GetMapping("/messages/history")
    public ResponseEntity<?> getMessageHistory(@RequestParam(value = "sender", required = false) long sender) {
        return new ResponseEntity<>(messageService.getMessageHistory(sender), HttpStatus.OK);
    }

    @PostMapping("/messages")
    public ResponseEntity<?> newMessage(@RequestBody Message newMessage) {
        newMessage.setId(0);

        return getResponseEntity(newMessage);
    }

    @PutMapping("/messages")
    public ResponseEntity<?> updateMessage(@RequestBody Message updatedMessage) {
        return getResponseEntity(updatedMessage);
    }

    private ResponseEntity<?> getResponseEntity(@RequestBody Message message) {
        Contact senderContact = contactService.findById(message.getSender().getId());
        Contact receiverContact = contactService.findById(message.getReceiver().getId());

        message.setSender(senderContact);
        message.setReceiver(receiverContact);

        return new ResponseEntity<>(messageService.save(message), HttpStatus.OK);
    }

    @DeleteMapping("/messages/{messageId}")
    public ResponseEntity<?> deleteMessage(@PathVariable long messageId) {
        messageService.deleteById(messageId);
        return ResponseEntity.status(200).body("Message deleted successfully!");
    }
}