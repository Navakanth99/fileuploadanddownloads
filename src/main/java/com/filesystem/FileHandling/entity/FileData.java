package com.filesystem.FileHandling.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FileData")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FileData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;

    @Lob  //for binary formate
    @Column(name = "fileData", length=500000)
    private byte[] fileData;

}
