package ru.vorobyoff.filehosting.services;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.vorobyoff.filehosting.models.FileDto;
import ru.vorobyoff.filehosting.repositories.FileDbRepository;
import ru.vorobyoff.filehosting.repositories.FileSystemRepository;

import java.io.IOException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class FileLocationService {

    private final FileSystemRepository systemRepository;
    private final FileDbRepository dbRepository;

    public FileLocationService(final FileSystemRepository systemRepository, final FileDbRepository dbRepository) {
        this.systemRepository = systemRepository;
        this.dbRepository = dbRepository;
    }

    public final Long save(final byte[] data, final String title) {
        try {
            final var location = systemRepository.save(data, title);
            final var dto = new FileDto();
            dto.setTitle(title);
            dto.setPath(location);

            return dbRepository.save(dto).getId();
        } catch (final IOException e) {
            throw new RuntimeException("I/O errors occur.", e);
        }
    }

    public final FileSystemResource find(Long imageId) {
        final var dto = dbRepository.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        return systemRepository.findInFileSystem(dto.getPath());
    }
}
