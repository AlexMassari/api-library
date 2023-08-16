package com.api.library.controller.impl;

import com.api.library.controller.PublisherController;
import com.api.library.entity.PublisherEntity;
import com.api.library.exception.NameAlreadyExistException;
import com.api.library.exception.NotFoundException;
import com.api.library.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/publisher")
public class PublisherControllerImpl implements PublisherController {

    private final PublisherService publisherService;

    @Override
    @GetMapping("/list")
    public List<PublisherEntity> getPublisherList(HttpServletRequest request) {
        return publisherService.getPublishers();
    }

    @Override
    @PostMapping("/add")
    public ResponseEntity<String> createPublisher(@RequestBody PublisherEntity publisher) {
        try {
            publisherService.insertPublisher(publisher.getPublisherName());
            return ResponseEntity.ok("Publisher inserted successfully");
        }
        catch (NameAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This name is already in database");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating publisher");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePublisher(@PathVariable(name="id") BigInteger publisherId, @RequestBody PublisherEntity publisher) {
        try{
            publisherService.updatePublisher(publisher.getPublisherName(), publisherId);
            return ResponseEntity.ok("Publisher updated successfully");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error !!! Publisher not found");
        } catch (NameAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This name is already in database");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating publisher");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable(name="id") BigInteger publisherId) {
        try {
            publisherService.deletePublisher(publisherId);
            return ResponseEntity.ok("Publisher deleted successfully");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error !!! Publisher not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting publisher");
        }
    }
}
