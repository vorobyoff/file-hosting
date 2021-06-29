package ru.vorobyoff.filehosting.repositories;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.time.LocalTime.now;

@Repository
public class FileSystemRepository {

    private static final String RESOURCE_DIR = FileSystemRepository.class.getResource("/").getPath();

    public final String save(final byte[] data, final String title) throws IOException {
        final var path = Paths.get(RESOURCE_DIR + now() + title);
        Files.createDirectories(path.getParent());
        Files.write(path, data);

        return path.toAbsolutePath().toString();
    }

    public final FileSystemResource findInFileSystem(final String location) {
        final var path = Paths.get(location);
        return new FileSystemResource(path);
    }
}
