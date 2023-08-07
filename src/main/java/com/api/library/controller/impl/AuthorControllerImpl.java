package com.api.library.controller.impl;

import com.api.library.controller.AuthorController;
import com.api.library.entity.AuthorEntity;
import com.api.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService authorService;
    @Override
    @PostMapping("/add")
    public ResponseEntity<String> createAuthor(@RequestBody AuthorEntity author) {
        authorService.insertAuthor(author.getAuthorName());
        return ResponseEntity.ok("Author inserted successfully");
    }
}
