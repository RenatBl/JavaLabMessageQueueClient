package ru.itis.messagequeue.services;

import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.Map;

@Service
public class TemplateProcessorServiceImpl implements TemplateProcessorService {

    @Autowired
    private Configuration fmConfiguration;

    @Override
    public String getContentFromTemplate(Map<String, Object> model, String templateName) {
        StringBuilder content = new StringBuilder();
        try {
            content.append(FreeMarkerTemplateUtils
                    .processTemplateIntoString(fmConfiguration.getTemplate(templateName), model));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return content.toString();
    }
}
