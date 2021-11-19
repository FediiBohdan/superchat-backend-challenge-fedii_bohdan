package ua.fedii.superchat.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.fedii.superchat.dao.MessageRepository;
import ua.fedii.superchat.model.Message;
import ua.fedii.superchat.service.MessageService;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message findById(long id) {
        Optional<Message> tempMessage = messageRepository.findById(id);

        Message message;

        if (tempMessage.isPresent()) {
            message = tempMessage.get();
        }
        else {
            throw new RuntimeException("Did not find message by id: " + id);
        }

        return message;
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteById(long id) {
        Optional<Message> tempMessage = messageRepository.findById(id);

        if (tempMessage.isPresent()) {
            messageRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Did not find message by id: " + id);
        }
    }
}
