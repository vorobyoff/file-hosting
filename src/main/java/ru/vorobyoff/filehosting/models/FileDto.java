package ru.vorobyoff.filehosting.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "UPLOADED_FILE")
public class FileDto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime lastModified;
    @Column(nullable = false)
    private String path;

    public FileDto(final Long id, final String title, final LocalDateTime createdAt,
                   final LocalDateTime lastModified, final String path) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
        this.path = path;
    }

    public FileDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(final LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public String getPath() {
        return path;
    }

    public void setPath(final String content) {
        this.path = content;
    }
}