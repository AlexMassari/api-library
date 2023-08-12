package com.api.library.service.impl;

import com.api.library.entity.AuthorEntity;
import com.api.library.exception.NameAlreadyExistException;
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
    public void insertAuthor(String name) throws NameAlreadyExistException {
        AuthorEntity author=authorRepository.getAuthorByName(name).orElse(null);
        if(author==null){
            authorRepository.insertAuthor(name);
        } else{
            throw new NameAlreadyExistException("El nombre ingresado ya existe");
        }

    }

    @Override
    @Transactional
    public void updateAuthor(String authorName, BigInteger authorId) throws NotFoundException, NameAlreadyExistException {
        AuthorEntity authorById=authorRepository.getAuthorById(authorId).orElse(null);
        AuthorEntity authorByName=authorRepository.getAuthorByName(authorName).orElse(null);
        if(authorById==null){
            throw new NotFoundException("Author not found");
        } else if(authorByName!=null){
            throw new NameAlreadyExistException("Author name already exist");
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
