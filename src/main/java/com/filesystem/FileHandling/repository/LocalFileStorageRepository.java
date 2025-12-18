package com.filesystem.FileHandling.repository;

import com.filesystem.FileHandling.entity.FileData;
import com.filesystem.FileHandling.entity.LocalFileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalFileStorageRepository extends JpaRepository<LocalFileData, Long> {
    Optional<LocalFileData> findByName(String fileName);
}
