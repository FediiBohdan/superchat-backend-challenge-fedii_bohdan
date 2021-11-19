package ua.fedii.superchat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.fedii.superchat.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
