package com.filesystem.FileHandling.controller;

import com.filesystem.FileHandling.service.LocalStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/filesystem")
public class LocalFileStorageController {

    @Autowired
    private LocalStorageService service;

    @PostMapping
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("file")MultipartFile file) throws IOException {
        String uploadFile = service.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadFile);

    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte [] fileData = service.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(fileData);
    }



}
