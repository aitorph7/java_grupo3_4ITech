package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.services.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
@RestControllerAdvice
public class FileController {
    private final FileService fileService;

    // http://localhost:8080/files/author-f6946523-59fb-4775-a6f9-d081b24a2618.webp
    @GetMapping("files/{name:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String name) {
        Resource file = fileService.load(name);
        return ResponseEntity.ok(file);
    }
}
