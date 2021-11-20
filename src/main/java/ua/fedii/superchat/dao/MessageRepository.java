package ua.fedii.superchat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.fedii.superchat.model.Message;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query(value = "SELECT * FROM Message m WHERE m.sender_id = ?1", nativeQuery = true)
    List<Message> getMessageHistory(long sender);
}