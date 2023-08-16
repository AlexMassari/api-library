package com.api.library.service.impl;

import com.api.library.entity.AuthorEntity;
import com.api.library.exception.NameAlreadyExistException;
import com.api.library.exception.NotFoundException;
import com.api.library.repository.AuthorRepository;
import com.api.library.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;

    @Override
    public List<AuthorEntity> getAuthors() {
        List<AuthorEntity> authorEntities = authorRepository.listAuthors();
        return new ArrayList<>(authorEntities);
    }

    @Override
    @Transactional
    public void insertAuthor(String authorName) throws NameAlreadyExistException {
        AuthorEntity author=authorRepository.getAuthorByName(authorName).orElse(null);
        if(author==null){
            authorRepository.insertAuthor(authorName);
        } else{
            throw new NameAlreadyExistException("Author name already exist");
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
