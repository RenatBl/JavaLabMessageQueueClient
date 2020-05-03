package ru.itis.messagequeue.services;

import java.util.Map;

public interface TemplateProcessorService {
    String getContentFromTemplate(Map<String, Object> model, String templateName);
}
