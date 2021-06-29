package ru.vorobyoff.filehosting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vorobyoff.filehosting.repositories.FileDbRepository;

@Controller
public class IndexPageController {

    private final FileDbRepository dbRepository;

    public IndexPageController(final FileDbRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    @GetMapping(value = {"/", "/files", "/files.html"})
    public final String showFiles(final Model model) {
        final var files = dbRepository.findAll();
        model.addAttribute("files", files);
        return "index";
    }
}
