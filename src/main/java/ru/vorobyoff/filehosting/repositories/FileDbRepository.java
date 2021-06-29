package ru.vorobyoff.filehosting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vorobyoff.filehosting.models.FileDto;

public interface FileDbRepository extends JpaRepository<FileDto, Long> {
}