package com.api.library.service;

import com.api.library.entity.PublisherEntity;
import com.api.library.exception.NameAlreadyExistException;
import com.api.library.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public interface PublisherService {

    List<PublisherEntity> getPublishers();

    void insertPublisher(String publisherName) throws NameAlreadyExistException;

    void updatePublisher(String publisherName, BigInteger publisherId) throws NotFoundException, NameAlreadyExistException;

    void deletePublisher(BigInteger publisherId) throws NotFoundException;

}
