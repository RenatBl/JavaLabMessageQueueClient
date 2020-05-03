package ru.itis.messagequeue.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileInfoDto {
    private String storageFileName;
    private String fileName;
    private String owner;
    private String email;
}
