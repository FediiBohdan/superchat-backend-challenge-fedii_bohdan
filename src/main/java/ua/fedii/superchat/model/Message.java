package ua.fedii.superchat.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="message")
@SQLDelete(sql = "UPDATE message SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sender_id")
    private Contact sender;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="receiver_id")
    private Contact receiver;

    @Column(name = "content")
    private String content;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Message() {}

    public Message(Contact sender, Contact receiver, String content, LocalDateTime updateDate, boolean isDeleted) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.updateDate = updateDate;
        this.isDeleted = isDeleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Contact getSender() {
        return sender;
    }

    public void setSender(Contact sender) {
        this.sender = sender;
    }

    public Contact getReceiver() {
        return receiver;
    }

    public void setReceiver(Contact receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", content='" + content + '\'' +
                ", updateDate=" + updateDate +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
