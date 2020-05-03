package ru.itis.messagequeue.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentForm {
    private String header;
    private String text;
    private String owner;
    private String email;
}
