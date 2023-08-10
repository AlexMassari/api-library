package com.api.library.controller.impl;

import com.api.library.controller.AuthorController;
import com.api.library.entity.AuthorEntity;
import com.api.library.exception.NotFoundException;
import com.api.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService authorService;
    @Override
    @PostMapping("/add")
    public ResponseEntity<String> createAuthor(@RequestBody AuthorEntity author) {
        try {
            authorService.insertAuthor(author.getAuthorName());
            return ResponseEntity.ok("Author inserted successfully");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating author");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable(name="id") BigInteger authorId, @RequestBody AuthorEntity author) {

        try{
            authorService.updateAuthor(author.getAuthorName(), authorId);
            return ResponseEntity.ok("Author updated successfully");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error !!! Author not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting author");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable(name="id") BigInteger authorId) {
        try {
            authorService.deleteAuthor(authorId);
            return ResponseEntity.ok("Author deleted successfully");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error !!! Author not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting author");
        }
    }
}
