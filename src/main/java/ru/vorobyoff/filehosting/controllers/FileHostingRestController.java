package ru.vorobyoff.filehosting.controllers;

import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.vorobyoff.filehosting.services.FileLocationService;

import java.io.IOException;

import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;

@RestController
public class FileHostingRestController {

    private final FileLocationService locationService;

    public FileHostingRestController(final FileLocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping(value = "/upload")
    public final Long upload(@RequestParam("file") final MultipartFile file) throws IOException {
        return locationService.save(file.getBytes(), file.getName());
    }

    @GetMapping(value = "/file/{fileId}", produces = IMAGE_JPEG_VALUE)
    public final Resource download(@PathVariable final Long fileId) {
        return locationService.find(fileId);
    }
}
