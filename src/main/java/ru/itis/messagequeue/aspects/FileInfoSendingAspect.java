package ru.itis.messagequeue.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.messagequeue.dto.FileInfoDto;
import ru.itis.messagequeue.models.Mail;
import ru.itis.messagequeue.services.MailService;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class FileInfoSendingAspect {

    @Autowired
    private MailService service;

    @AfterReturning(pointcut = "execution(* ru.itis.messagequeue.controllers.MainController.get())", returning = "dto")
    public void log(FileInfoDto dto) {
        System.out.println("___________________");
        System.out.println("Sending message");

        String username = dto.getOwner();
        String email = dto.getEmail();

        Map<String, Object> model = new HashMap<>();
        model.put("username", username);
        model.put("url", dto.getStorageFileName());

        service.sendMail(Mail.builder().model(model)
                .mailSubject(username + "your file done")
                .mailTo(email)
                .build(), "fileMail.txt");

        System.out.println("Message sent to " + dto.getEmail());
    }
}
