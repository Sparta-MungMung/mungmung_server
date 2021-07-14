package com.sparta.mungmung.controller;

import com.sparta.mungmung.security.UserDetailsImpl;
import com.sparta.mungmung.service.UserService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final UserService userService;

    @PostMapping("/attachments")
    public ResponseEntity<?> uploadAttachment(@RequestParam(name = "file") MultipartFile sourceFile, @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {

        String sourceFileName = sourceFile.getOriginalFilename();
        String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();

        File destinationFile;
        String destinationFileName;
        do {
            destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension;
            destinationFile = new File("/home/ubuntu/" + destinationFileName);
        } while (destinationFile.exists());
        destinationFile.getParentFile().mkdirs();
        sourceFile.transferTo(destinationFile);

        UploadAttachmentResponse response = new UploadAttachmentResponse();
        response.setFileName(sourceFile.getOriginalFilename());
        response.setFileSize(sourceFile.getSize());
        response.setFileContentType(sourceFile.getContentType());
        response.setAttachmentUrl("http://52.79.234.172/attachments/" + destinationFileName);

        Long userId = userDetails.getUser().getUserId();
        userService.setDogImage(destinationFileName, userId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @NoArgsConstructor
    @Data
    private static class UploadAttachmentResponse {

        private String fileName;

        private long fileSize;

        private String fileContentType;

        private String attachmentUrl;
    }
}