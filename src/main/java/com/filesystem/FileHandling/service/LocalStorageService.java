package com.filesystem.FileHandling.service;

import com.filesystem.FileHandling.entity.LocalFileData;
import com.filesystem.FileHandling.repository.LocalFileStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class LocalStorageService {

    @Autowired
    private LocalFileStorageRepository repository;

    private final String Folder = "C:/MyFiles/";

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
      String filepath =Folder+file.getOriginalFilename();
        LocalFileData fileData =repository.save(LocalFileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filepath).build());

        file.transferTo(new File(filepath));
        if(fileData != null){
            return "File uploaded successfully : "+filepath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<LocalFileData> fileData= repository.findByName(fileName);
        String filePath = fileData.get().getFilePath();
        byte [] image = Files.readAllBytes(new File(filePath).toPath());
        return image;
    }

}
