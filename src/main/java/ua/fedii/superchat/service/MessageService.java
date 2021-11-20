package ua.fedii.superchat.service;

import ua.fedii.superchat.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAll();
    List<Message> getMessageHistory(long sender);
    Message findById(long id);
    Message save(Message message);
    void deleteById(long id);
}
