package ru.itis.messagequeue.services;

import ru.itis.messagequeue.dto.FileDto;
import ru.itis.messagequeue.dto.FileInfoDto;
import ru.itis.messagequeue.forms.DocumentForm;

public interface DocumentCreatingService {
    FileInfoDto createPDF(DocumentForm form);
}
