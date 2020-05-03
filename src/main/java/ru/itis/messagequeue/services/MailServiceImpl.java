package ru.itis.messagequeue.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ru.itis.messagequeue.models.Mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateProcessorService service;

    @Override
    public void sendMail(Mail mail, String templateName) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject(mail.getMailSubject());
            mimeMessageHelper.setFrom("context.test.itis@gmail.com");
            mimeMessageHelper.setTo(mail.getMailTo());
            mail.setMailContent(service.getContentFromTemplate(mail.getModel(), templateName));
            mimeMessageHelper.setText(mail.getMailContent(), true);

            mailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            throw new IllegalStateException(e);
        }
    }
}
