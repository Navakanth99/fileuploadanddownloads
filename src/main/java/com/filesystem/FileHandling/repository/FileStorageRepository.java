package com.filesystem.FileHandling.repository;

import com.filesystem.FileHandling.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileStorageRepository extends JpaRepository<FileData, Long> {

    Optional<FileData> findByName(String fileName);
}
