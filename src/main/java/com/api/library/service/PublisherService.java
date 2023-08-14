package com.api.library.service;

import com.api.library.exception.NameAlreadyExistException;
import com.api.library.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public interface PublisherService {

    void insertPublisher(String publisherName) throws NameAlreadyExistException;

    void updatePublisher(String publisherName, BigInteger id) throws NotFoundException, NameAlreadyExistException;

    void deletePublisher(BigInteger id) throws NotFoundException;

}
