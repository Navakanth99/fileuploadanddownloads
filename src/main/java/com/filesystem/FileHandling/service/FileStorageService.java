package com.filesystem.FileHandling.service;

import com.filesystem.FileHandling.entity.FileData;
import com.filesystem.FileHandling.repository.FileStorageRepository;
import com.filesystem.FileHandling.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileStorageService {

    @Autowired
    private FileStorageRepository repository;

    public String uploadImage(MultipartFile file) throws IOException {
        FileData fileData= repository.save(FileData.builder().name(file.getOriginalFilename()).type(file.getContentType()).fileData(ImageUtils.compressImage(file.getBytes()) ).build());
        if(fileData != null){
            return "File uploaded successfully "+file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadFile(String fileName){
        Optional<FileData> dbFileData =repository.findByName(fileName);
        byte[] file =ImageUtils.decompressImage(dbFileData.get().getFileData());
        return file;
    }

}
