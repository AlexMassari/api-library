package com.api.library.service.impl;

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
    public void updateAuthor(String authorName, BigInteger id) {
        authorRepository.updateAuthor(authorName, id);
    }
}
