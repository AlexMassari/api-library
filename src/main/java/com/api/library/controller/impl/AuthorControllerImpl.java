package com.api.library.controller.impl;

import com.api.library.controller.AuthorController;
import com.api.library.entity.AuthorEntity;
import com.api.library.exception.NameAlreadyExistException;
import com.api.library.exception.NotFoundException;
import com.api.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService authorService;

    @Override
    @GetMapping("/list")
    public List<AuthorEntity> getAuthorsList(HttpServletRequest request) {
        return authorService.getAuthors();
    }

    @Override
    @PostMapping("/add")
    public ResponseEntity<String> createAuthor(@RequestBody AuthorEntity author) {
        try {
            authorService.insertAuthor(author.getAuthorName());
            return ResponseEntity.ok("Author inserted successfully");
        }
        catch (NameAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This name is already in database");
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
        } catch (NameAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This name is already in database");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating author");
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
