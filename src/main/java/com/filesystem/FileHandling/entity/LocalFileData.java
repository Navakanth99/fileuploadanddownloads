package com.filesystem.FileHandling.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LOCAL_DATA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocalFileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    private String filePath;
}
