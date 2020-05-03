package ru.itis.messagequeue.services;

import ru.itis.messagequeue.models.Mail;

public interface MailService {
    void sendMail(Mail mail, String templateName);
}
