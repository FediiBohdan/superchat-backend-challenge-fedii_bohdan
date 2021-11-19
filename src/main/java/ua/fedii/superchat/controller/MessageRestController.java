package ua.fedii.superchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.fedii.superchat.model.Message;
import ua.fedii.superchat.service.ContactService;
import ua.fedii.superchat.service.MessageService;

@RestController
@RequestMapping("/api")
public class MessageRestController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/messages")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(messageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/messages/{messageId}")
    public ResponseEntity<?> getMessage(@PathVariable int messageId) {
        return new ResponseEntity<>(messageService.findById(messageId), HttpStatus.OK);
    }

    @PostMapping("/messages")
    public ResponseEntity<?> newMessage(@RequestBody Message newMessage) {
        newMessage.setId(0);

        return new ResponseEntity<>(messageService.save(newMessage), HttpStatus.OK);
    }

    @PutMapping("/messages")
    public ResponseEntity<?> updateMessage(@RequestBody Message updatedMessage) {
        return new ResponseEntity<>(messageService.save(updatedMessage), HttpStatus.OK);
    }

    @DeleteMapping("/messages/{messageId}")
    public ResponseEntity<?> deleteMessage(@PathVariable long messageId) {
        messageService.deleteById(messageId);
        return ResponseEntity.status(200).body("Message deleted successfully!");
    }
}
