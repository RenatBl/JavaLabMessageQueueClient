package ru.itis.messagequeue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.messagequeue.models.Message;

public interface MessagesRepository extends JpaRepository<Message, Long> {
}
