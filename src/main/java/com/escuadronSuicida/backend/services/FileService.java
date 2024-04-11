package com.escuadronSuicida.backend.services;


import com.escuadronSuicida.backend.exception.FileException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Slf4j
public class FileService {

    public String store(MultipartFile file) {
        String newFileName = generateUniqueName(file);

        try {
            InputStream inputStream = file.getInputStream();
            Path filePath = Paths.get("uploads").resolve(newFileName);
            Files.copy(inputStream,filePath);
            return newFileName; // El nombre del archivo almacenado
        } catch (IOException e) {
            log.error("Error al leer/guardar archivo", e);
            throw new FileException("Error al guardar archivo");
        }
    }

    public Resource load(String name) {
        Path file = Paths.get("uploads").resolve(name);
        try {
            Resource resource = new UrlResource(file.toUri());
            if(!resource.exists() || !resource.isReadable())
                throw new FileException("Error al intentar cargar el archivo");

            return resource;
        } catch (MalformedURLException e) {
            throw new FileException("Error al intentar cargar el archivo");
        }
    }

    private String generateUniqueName(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        if (!StringUtils.hasLength(originalFileName) || file.isEmpty())
            throw new FileException("Error al leer archivo");

        String fileName = StringUtils.cleanPath(originalFileName);
        String extension = StringUtils.getFilenameExtension(fileName);
        String fileNameWithoutExt = fileName.replace("." + extension, "");
        return fileNameWithoutExt + "-" + UUID.randomUUID() + "." + extension;
    }
}
