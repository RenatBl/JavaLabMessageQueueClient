package ru.itis.messagequeue.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import ru.itis.messagequeue.dto.FileInfoDto;
import ru.itis.messagequeue.forms.DocumentForm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class DocumentCreatingServiceImpl implements DocumentCreatingService {

    private final static String FILE_PATH = "C:\\java2019\\files\\";
    private final static int FONT_SIZE_SMALL = 16;
    private final static int FONT_SIZE_BIG = 32;

    @Override
    public FileInfoDto createPDF(DocumentForm form) {
        FileInfoDto infoDto = new FileInfoDto();

        Document document = new Document(PageSize.A4);

        String fileName = getName(form.getOwner());
        infoDto.setFileName(fileName);

        String url = FILE_PATH + fileName;
        infoDto.setStorageFileName(url);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(url));
        } catch (DocumentException | FileNotFoundException e) {
            throw new IllegalStateException(e);
        }

        document.open();

        Font font1 = new Font(Font.FontFamily.HELVETICA,
                FONT_SIZE_BIG, Font.BOLD);
        Font font2 = new Font(Font.FontFamily.HELVETICA,
                FONT_SIZE_SMALL, Font.ITALIC);

        Paragraph header = new Paragraph(form.getHeader(), font1);
        header.setAlignment(Element.ALIGN_CENTER);
        header.setSpacingAfter(FONT_SIZE_BIG);

        Paragraph text = new Paragraph(form.getText(), font2);
        text.setSpacingAfter(FONT_SIZE_SMALL);

        Paragraph owner = new Paragraph(form.getOwner(), font2);
        owner.setSpacingAfter(FONT_SIZE_SMALL);
        owner.setAlignment(Element.ALIGN_BOTTOM | Element.ALIGN_RIGHT);

        try {
            document.add(header);
            document.add(text);
            document.add(owner);
        } catch (DocumentException e) {
            throw new IllegalStateException(e);
        }

        document.close();

        infoDto.setEmail(form.getOwner());
        infoDto.setOwner(form.getEmail());
        return infoDto;
    }

    private String getName(String owner) {
        LocalDateTime dateTime = LocalDateTime.now();
        String s = owner;
        s += " " + dateTime.getHour() + "-" + dateTime.getMinute() + "-" + dateTime.getSecond() + "_"
                + dateTime.getDayOfMonth() + "-" + dateTime.getMonthValue() + "-" + dateTime.getYear();
        s += ".pdf";
        return s;
    }
}
