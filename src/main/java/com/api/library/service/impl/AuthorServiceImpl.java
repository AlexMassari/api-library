package com.api.library.service.impl;

import com.api.library.entity.AuthorEntity;
import com.api.library.exception.NotFoundException;
import com.api.library.repository.AuthorRepository;
import com.api.library.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;
    @Override
    @Transactional
    public void insertAuthor(String name) {

        authorRepository.insertAuthor(name);
    }

    @Override
    @Transactional
    public void updateAuthor(String authorName, BigInteger authorId) throws NotFoundException {
        AuthorEntity author=authorRepository.getAuthorById(authorId).orElse(null);
        if(author==null){
            throw new NotFoundException("Author not found");
        }
        authorRepository.updateAuthor(authorName, authorId);
    }

    @Override
    @Transactional
    public void deleteAuthor(BigInteger authorId) throws NotFoundException {
        AuthorEntity author=authorRepository.getAuthorById(authorId).orElse(null);
        if(author==null){
            throw new NotFoundException("Author not found");
        }
        authorRepository.deleteAuthor(authorId);
    }


}
